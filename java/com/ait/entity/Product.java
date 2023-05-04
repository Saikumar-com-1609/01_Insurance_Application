package com.ait.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products_tbl")
public class Product {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private Double price;
	private Integer quantity;
	

}
