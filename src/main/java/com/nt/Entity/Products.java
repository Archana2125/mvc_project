package com.nt.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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

import com.mysql.cj.jdbc.Blob;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	private LocalDate manufactor_date;
	
	private LocalDate expire_date;
	
	private String batch_no;
	
	@Lob
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")  
	private Brands brand;
	
	@OneToMany(mappedBy = "product")
	private List<OrderItem> orderItems;
	
	
	

}
