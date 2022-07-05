package com.thang.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ProductDao {
	private int id;
	private int subcateId;
	private String produceName;
	private String color;
	private int quantity;
	private double sellPrice;
	private double originPrice;
	private String description;
	private int statusId;
}
