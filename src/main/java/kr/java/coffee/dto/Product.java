package kr.java.coffee.dto;

public class Product {
	private String code;
	private String name;
	private int price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Product(String code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product [%s, %s, %s]", code, name, price);
	}
	
}
