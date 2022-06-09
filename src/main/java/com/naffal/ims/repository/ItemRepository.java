package com.naffal.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.naffal.ims.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> { // Or, itemDao

}
