package com.thang.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thang.model.ResponsiveObject;
import com.thang.model.entity.SubCategory;
import com.thang.service.SubCategoryService;

@RestController
@RequestMapping("/api")
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategory;
	
	@GetMapping("/subcategory")
	public Page<SubCategory> viewhomePage(Model model) {
		return listPages(1,model);
	}
	
	@GetMapping("/subcategory/{contentId}")
	public Page<SubCategory> listPages(@PathVariable(name = "contentId", required = true) int index, Model model) {
		int currentPage = index;
		Page<SubCategory> page = subCategory.listAll(currentPage);
		long totalImtems = page.getNumberOfElements();
		long totalPages = page.getTotalPages();
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalImtems", totalImtems);
		model.addAttribute("totalPages", totalPages);
		return page;
	}
	
	@PostMapping()
	public ResponseEntity<ResponsiveObject> saveCate(@Valid @RequestBody SubCategory subCate, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsiveObject(false,"","error"));
		}
		SubCategory category = subCategory.save(subCate);
		return  ResponseEntity.status(HttpStatus.OK).body(new ResponsiveObject(true,category,"success"));		
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<ResponsiveObject> updateSubcate(@PathVariable int id,@Valid @RequestBody SubCategory subCate, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsiveObject(false,"","error"));
		}
		SubCategory category = subCategory.update(id,subCate);
		return  ResponseEntity.status(HttpStatus.OK).body(new ResponsiveObject(true,category,"success"));		
	}
	
}