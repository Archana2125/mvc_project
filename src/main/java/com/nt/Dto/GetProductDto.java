package com.nt.Dto;

import java.math.BigDecimal;

public class GetProductDto {
	
	private Long id;
	private String name;
	private String base64Image;
	private BigDecimal price;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public GetProductDto(Long id, String name, String base64Image, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.base64Image = base64Image;
		this.price = price;
	}
	public GetProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GetProductDto [id=" + id + ", name=" + name + ", base64Image=" + base64Image + ", price=" + price + "]";
	}
	
	
	
	
	
	

}
