package com.naffal.ims.service;

import java.util.Collection;

import com.naffal.ims.model.Item;

public interface ItemService {

	void createItem(Item item);

	void updateItem(String id, Item item);

	void deleteItem(String id);

	Collection<Item> getItems();

}
