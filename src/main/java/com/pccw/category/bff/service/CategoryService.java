package com.pccw.category.bff.service;

import java.util.Map;

import com.pccw.category.bff.dto.Category;

public interface CategoryService {

	Category createCategory(Category category);
	
	Category retrieveCategorybyId(Map<String,Object> pathParams, Map<String,Object> queryParams);
	
	
	Category patchCategory(Map<String, Object> pathParams, Category category);

	String listCategory(Map<String, Object> reqParams);
	
}
