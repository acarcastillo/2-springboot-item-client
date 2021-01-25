package com.products.items.boot.models;

public class Item {

	private Product product;

	private Integer quantity;

	public Item() {
	}

	public Item(Product product, Integer ammountToPay) {
		this.product = product;
		this.quantity = ammountToPay;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getTotal() {
		return product.getAmmount()*quantity.doubleValue();
	}

}
