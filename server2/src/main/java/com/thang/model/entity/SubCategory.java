package com.thang.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "sub_category")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "sub_cate_code")
	@NotEmpty(message = "thieu subCateCode")
	@Pattern(regexp = "SA+[0-9]{4}")
	private String subCateCode;
	@Column(name = "sub_cate_name")
	@NotEmpty(message = "thieu subCateName")
	@Pattern(regexp  = "[a-zA-Z]+")
	private String subCateName;
	@Column(name = "cate_id")
	@NotNull(message = "thieu cateId")
	private int cateId;

//	@OneToMany(mappedBy = "subCategory")
//	private List<Product> products;
}
