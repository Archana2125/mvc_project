package com.nt.Entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



@Entity
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	private String category_name;
	
	@Lob
	private byte[] image;
	
//getter setter
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	
	
	public Categories(Long category_id, String category_name, byte[] image) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.image = image;
	}

	
	
	public Categories() {
		super();
		
	}

	@Override
	public String toString() {
		return "Categories [category_id=" + category_id + ", category_name=" + category_name + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	

}