package com.naffal.ims.controller;

import java.util.HashMap;
import javax.validation.Valid;  

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.naffal.ims.exception.ResourceNotFoundException;
import com.naffal.ims.model.Item;
import com.naffal.ims.repository.ItemRepository;


@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/v1/")
public class ItemController {
	
	//HATEOS implementation ref : https://www.baeldung.com/spring-hateoas-tutorial
	// Create ItemService before implementing HateOS.. as new methods needs to be defined.. except ccotroller methods
	// in controller itself, thhe code will look ugly... so I am going to create new service for controller. 
	// Creating service reference : https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm


	@Autowired
	private ItemRepository itemRepository;

	// get all items
	@GetMapping("/items")
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}		

	// create item rest api
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}

	// get item by id rest api
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		return ResponseEntity.ok(item);
	}

	// update item rest api
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails){
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));

		item.setItemName(itemDetails.getItemName());

		Item updatedItem = itemRepository.save(item);
		return ResponseEntity.ok(updatedItem);
	}
	
	// delete all items rest api
	@DeleteMapping("/items")
	public ResponseEntity<Map<String, Boolean>> deleteAllItems(){
		itemRepository.deleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted all items", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// delete item rest api
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id){
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));

		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
