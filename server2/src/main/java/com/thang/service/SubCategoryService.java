package com.thang.service;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.thang.model.entity.SubCategory;
import com.thang.repository.SubCategoryRespository;

@Service
public class SubCategoryService {

	@Autowired
	private SubCategoryRespository repo;
	
	public List<SubCategory> getList(){
		return repo.findAll();
	}
	
	public Page<SubCategory> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber-1,2);
		return repo.findAll(pageable);
		
	}
	
	public SubCategory save(SubCategory subCategory) {
			return repo.save(subCategory);
	}
	
	public SubCategory update(int id, SubCategory subCategory) {
		SubCategory updateSubCate = repo.findById(id).orElse(null);
		updateSubCate.setSubCateName(subCategory.getSubCateName());
		updateSubCate.setSubCateCode(subCategory.getSubCateCode());
		updateSubCate.setCateId(subCategory.getCateId());
		return repo.save(updateSubCate);
	}
}

