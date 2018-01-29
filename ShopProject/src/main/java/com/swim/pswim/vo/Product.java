package com.swim.pswim.vo;

public class Product {
	private String productCode;
	private String productName;
	private String productPrice;
	private String productImage;
	private String basicImage;
	private String seller;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productCode, String productName, String productPrice, String productImage, String basicImage,
			String seller) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.basicImage = basicImage;
		this.seller = seller;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getBasicImage() {
		return basicImage;
	}

	public void setBasicImage(String basicImage) {
		this.basicImage = basicImage;
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
				+ ", productImage=" + productImage + ", basicImage=" + basicImage + ", seller=" + seller + "]";
	}

	
	
	
	
	
	
}
