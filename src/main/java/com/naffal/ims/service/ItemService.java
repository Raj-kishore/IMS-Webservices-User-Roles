package com.naffal.ims.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.naffal.ims.model.Item;

public interface ItemService {

	Item createItem(Item item);

	ResponseEntity<Item> updateItem(Long id, Item item);

	List<Item> getItems();
	
	ResponseEntity<Item> getItemById(Long id);
	
	ResponseEntity<Map<String, Boolean>> deleteItem(Long id);
	
	ResponseEntity<Map<String, Boolean>> deleteAll();

}
