package com.thang.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thang.model.ProductDao;
import com.thang.model.entity.*;
import com.thang.repository.BrandRespository;
import com.thang.repository.ProductRespository;
import com.thang.repository.SubCategoryRespository;

@Service
public class ProductService {

	@Autowired
	private ProductRespository productRespository;
	
	@Autowired
	private SubCategoryRespository subCategoryRespository;
	
	@Autowired
	private BrandRespository brandRespository;
	
	public Page<Product> getList(int index){
		Pageable pageable = PageRequest.of(index-1, 5);
		return productRespository.findAll(pageable);
	}
	
	public List<Product> getLists(){
		return productRespository.findAll();
	}
	
	public Product save(int Brandid, ProductDao productDTo ) {
		Product product = new Product();
		Brand brand = brandRespository.findById(Brandid).orElse(null);
		SubCategory subCategory = subCategoryRespository.findById(productDTo.getStatusId()).orElse(null);
		if(brand == null || subCategory == null) {
			return null;
		}
		product.setSubCategory(subCategory);
		BeanUtils.copyProperties( productDTo, product);
		return productRespository.save(product);
	}
	
	public String delete(int id) {
		productRespository.deleteById(id);
		return "Xoá thành công" + id;
	}
	
//	public Product update(int id, Product product) {
//		Product updateProduct = productRespository.findById(id).orElse(null);
//		updateProduct.setSubcateId(product.getSubcateId());
//		updateProduct.setProductName(product.getProductName());
//		updateProduct.setColor(product.getColor());
//		updateProduct.setQuantity(product.getQuantity());
//		updateProduct.setSellPrice(product.getSellPrice());
//		updateProduct.setOriginPrice(product.getOriginPrice());
//		updateProduct.setDescription(product.getDescription());
//		updateProduct.setStatusId(product.getStatusId());
//	
//		return productRespository.save(updateProduct);
//	}
}
