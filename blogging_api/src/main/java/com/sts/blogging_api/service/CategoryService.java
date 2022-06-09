package com.sts.blogging_api.service;

import java.util.List;

import com.sts.blogging_api.payloads.CategoryDto;

public interface CategoryService {
   
     CategoryDto createCategory(CategoryDto category);
     CategoryDto updateCategory(CategoryDto category,Long id);
     CategoryDto getCategory(Long id);
     List<CategoryDto> getCategoryList();
     void deleteCategory(Long id);
    	 
     
}
