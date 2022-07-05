package com.thang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thang.model.ProductDao;
import com.thang.model.ResponsiveObject;
import com.thang.model.entity.*;
import com.thang.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	

	@GetMapping("/product")
	public Page<Product> viewhomePage(Model model) {
		return getAll(1,model);
	}
	
	@GetMapping("/product/{id}")
	public Page<Product> getAll(@PathVariable int index,Model model){
		int currentPage = index;
		Page<Product> page = productService.getList(currentPage);
		long totalImtems = page.getNumberOfElements();
		long totalPâge = page.getTotalElements();
		model.addAttribute("totalImtems", totalImtems);
		model.addAttribute("totalPâge", totalPâge);
		model.addAttribute("page", page);
		return page;
	}
	
	@GetMapping()
	public List<Product> List(Model model) {
		return productService.getLists();
	}
	
	@PostMapping("/product/{id}")
	public ResponseEntity<ResponsiveObject> addProduct(@PathVariable int id, @RequestBody ProductDao product) {
		Product product2 = productService.save(id, product);
		return product2 != null ? ResponseEntity.status(HttpStatus.OK).body(new ResponsiveObject(true,product2, "successful")):
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsiveObject(false,"", "error"));
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ResponsiveObject> deleteProduct(@PathVariable int id){
		String message = productService.delete(id);
		return message != null ? ResponseEntity.status(HttpStatus.OK).body(new ResponsiveObject(true,message, "successful")):
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsiveObject(false,message, "error"));
	}
	
}
