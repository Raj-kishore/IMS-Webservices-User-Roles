package com.naffal.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Items")
public class Item { // POJO class

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_type")
	private Integer itemType; // 1: product, 2: service

	@Column(name = "item_unit")
	private Integer itemUnit;  // 1: PC, 2: KG, 3: gm, 4: Ltr etc... 

	@Column(name = "item_qnt")
	private Integer itemQnt; // number of units 

	@Column(name = "item_selling_price")
	private Double itemSellingPrice;

	@Column(name = "item_cost_price")
	private Double itemCostPrice; // MRP

	@Column(name = "item_register_date")
	private String itemRegisterDate;

	public Item () { // no-arg constructor

	}
	public Item(long id, String itemName, Integer itemType, Integer itemUnit, Integer itemQnt, Double itemSellingPrice,
			Double itemCostPrice, String itemRegisterDate) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemUnit = itemUnit;
		this.itemQnt = itemQnt;
		this.itemSellingPrice = itemSellingPrice;
		this.itemCostPrice = itemCostPrice;
		this.itemRegisterDate = itemRegisterDate;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemType() {
		return itemType;
	}
	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}
	public Integer getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(Integer itemUnit) {
		this.itemUnit = itemUnit;
	}
	public Integer getItemQnt() {
		return itemQnt;
	}
	public void setItemQnt(Integer itemQnt) {
		this.itemQnt = itemQnt;
	}
	public Double getItemSellingPrice() {
		return itemSellingPrice;
	}
	public void setItemSellingPrice(Double itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}
	public Double getItemCostPrice() {
		return itemCostPrice;
	}
	public void setItemCostPrice(Double itemCostPrice) {
		this.itemCostPrice = itemCostPrice;
	}
	public String getItemRegisterDate() {
		return itemRegisterDate;
	}
	public void setItemRegisterDate(String itemRegisterDate) {
		this.itemRegisterDate = itemRegisterDate;
	}



}
