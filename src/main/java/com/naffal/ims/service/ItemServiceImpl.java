package com.naffal.ims.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.naffal.ims.exception.ResourceNotFoundException;
import com.naffal.ims.model.Item;
import com.naffal.ims.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public ResponseEntity<Item> updateItem(Long id, Item itemDetails) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		item.setItemName(itemDetails.getItemName());
		Item updatedItem = itemRepository.save(item);
		return ResponseEntity.ok(updatedItem);
	}

	@Override
	public List<Item> getItems() {
		return itemRepository.findAll();
	}

	

	@Override
	public ResponseEntity<Item> getItemById(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		return ResponseEntity.ok(item);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteAll() {
		itemRepository.deleteAll();
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted all items", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteItem(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));
		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}