package com.nt.Dto;

public class GetCategoryDto {
	
	private Long id;
	private String name;
	private String base64Image;
	
	
	
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
	public GetCategoryDto(Long id, String name, String base64Image) {
		super();
		this.id = id;
		this.name = name;
		this.base64Image = base64Image;
	}
	public GetCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GetCategoryDto [id=" + id + ", name=" + name + ", base64Image=" + base64Image + "]";
	}
	
	
	
	

}
