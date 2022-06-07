package com.naffal.ims.controller;

import java.util.HashMap;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
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
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*; //linkto() method


import com.naffal.ims.model.Item;
import com.naffal.ims.service.ItemServiceImpl;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/v1/")
public class ItemController {

	@Autowired
	private ItemServiceImpl itemServiceImpl;
	
	//Pending things for this app
	
	//hateos implemenation pending - hateos basically meta data in apis 
	// https://www.javatpoint.com/restful-web-services-hateoas
	//internationalization
    //	https://www.javatpoint.com/restful-web-services-internationalization
	// Content negotiation implementation
	// https://www.javatpoint.com/restful-web-services-content-negotiation
	// Actuator implementaiton 
	// https://www.javatpoint.com/restful-web-services-spring-boot-actuator
	
	

	// get all items
	@GetMapping("/items")
	public List<Item> getAllItems() {
		
//	    List<Item> allItems = itemServiceImpl.getItems();
//
//	    for (Item item : allItems) {
//	        Long itemId = item.getId();
//	        Link selfLink = linkTo(ItemController.class).slash(itemId).withSelfRel();
//	        item.add(selfLink);
//	        if (itemServiceImpl.getItemById(itemId).size() > 0) {
//	            Link ordersLink = linkTo(methodOn(CustomerController.class)
//	              .getOrdersForCustomer(customerId)).withRel("allOrders");
//	            customer.add(ordersLink);
//	        }
//	    }
//
//	    Link link = linkTo(CustomerController.class).withSelfRel();
//	    CollectionModel<Customer> result = CollectionModel.of(allCustomers, link);
//	    return result;
		return itemServiceImpl.getItems();
	}

	// create item rest api
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemServiceImpl.createItem(item);
	}

	// get item by id rest api
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Long id) {
		return itemServiceImpl.getItemById(id);
	}

	// update item rest api
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
		return itemServiceImpl.updateItem(id, itemDetails);
	}

	// delete all items rest api
	@DeleteMapping("/items")
	public ResponseEntity<Map<String, Boolean>> deleteAllItems() {
		return itemServiceImpl.deleteAll();
	}

	// delete item rest api
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id) {
		return itemServiceImpl.deleteItem(id);
	}

}
