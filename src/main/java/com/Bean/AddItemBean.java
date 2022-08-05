package com.Bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


public class AddItemBean {

	Integer itemId;
	Integer userId;
	Integer categoryId;
	Integer subCategoryId;
	Integer accountid;
	String accountNumber;
	String upiId;
	
	

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	@NotBlank(message = "please Enter ExpenseName")
	private String itemName;

	@NotBlank(message = "please ExpenseDescription")
	private String location;

	@NotNull(message = "please Enter digits")
	Integer price;

	private String item;

	@NotBlank(message = "please Enter date")
	private String date;

	@NotBlank(message = "please Enter time")
	private String time;
	
	String categoryName; 
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
