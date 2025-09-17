
package com.nt.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.cj.jdbc.Blob;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	
	private String product_name;
	
	private String description;
	
	private BigDecimal price;
	
	 private Integer stock_quantity;
	 
	@ManyToOne
    @JoinColumn(name = "category_id")
	private Categories category;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate manufactor_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expire_date;
	
	private String batch_no;
	
	@Lob
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")  
	private Brands brand;
	
	@OneToMany(mappedBy = "product")
	private List<OrderItem> orderItems;

	
	
	//getter setter
	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(Integer stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

	public LocalDate getManufactor_date() {
		return manufactor_date;
	}

	public void setManufactor_date(LocalDate manufactor_date) {
		this.manufactor_date = manufactor_date;
	}

	public LocalDate getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(LocalDate expire_date) {
		this.expire_date = expire_date;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Brands getBrand() {
		return brand;
	}

	public void setBrand(Brands brand) {
		this.brand = brand;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Products(Long product_id, String product_name, String description, BigDecimal price, Integer stock_quantity,
			Categories category, LocalDate manufactor_date, LocalDate expire_date, String batch_no, byte[] image,
			Brands brand, List<OrderItem> orderItems) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.category = category;
		this.manufactor_date = manufactor_date;
		this.expire_date = expire_date;
		this.batch_no = batch_no;
		this.image = image;
		this.brand = brand;
		this.orderItems = orderItems;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Products [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
				+ ", price=" + price + ", stock_quantity=" + stock_quantity + ", category=" + category
				+ ", manufactor_date=" + manufactor_date + ", expire_date=" + expire_date + ", batch_no=" + batch_no
				+ ", image=" + Arrays.toString(image) + ", brand=" + brand + ", orderItems=" + orderItems + "]";
	}
	
	
	
	
	

}
