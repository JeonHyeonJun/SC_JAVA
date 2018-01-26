package com.swim.pswim.vo;

public class Product {
	private int productCode;
	private String productName;
	private int productPrice;
	private String productImage;
	private String seller;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int productCode, String productName, int productPrice, String productImage, String seller) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.seller = seller;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productImage=" + productImage + ", seller=" + seller + "]";
	}
	
	
	
	
}
