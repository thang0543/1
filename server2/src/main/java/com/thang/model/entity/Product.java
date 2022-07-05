package com.thang.model.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "product")
public class Product{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="subcate_id")
	private SubCategory subCategory;
	
	@Column(name= "produce_name")
	private String productName;
	@Column(name= "color")
	private String color;
	@Column(name= "quantity")
	private int quantity;
	@Column(name= "sell_price")
	private double sellPrice;
	@Column(name= "origin_price")
	private double originPrice;
	@Column(name= "description")
	private String description;
	@Column(name= "status_id")
	private int statusId;

	
	
//	@OneToMany
//	@JoinColumn(name="id")
//	private List<status> status;
//	
	
}
