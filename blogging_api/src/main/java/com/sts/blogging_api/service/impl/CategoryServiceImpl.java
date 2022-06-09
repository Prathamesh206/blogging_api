package com.sts.blogging_api.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.blogging_api.entites.Category;
import com.sts.blogging_api.exception.ResourceNotFound;
import com.sts.blogging_api.payloads.CategoryDto;
import com.sts.blogging_api.repositories.CategoryRepo;
import com.sts.blogging_api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ModelMapper modelMapper;

	/*
	 *
	 * 
	 * createCategory method user for stored new category in the database
	 */
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category    category=   this.dtoTocatCategory(categoryDto);
		Category  category2=    this.categoryRepo.save(category);
		return this.cateoryTodto(category2);
	}

	/*
	 * 
	 *updateCategory method use for update the category 
	 * 
	 * 
	 */

	@Override
	public CategoryDto updateCategory(CategoryDto category, Long id) {
		Category category2=   this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user","user not found",id));
		category2.setDescription(category.getDescription());
		category2.setTitle(category.getTitle());
		Category eategory=this.categoryRepo.save(category2);
		return this.cateoryTodto(eategory);
	}

	/*
	 * 
	 * 
	 * getCategory method use for fetch the category from the database
	 */

	@Override
	public CategoryDto getCategory(Long id) {
		Category category=this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user","user not found",id));
		return this.cateoryTodto(category);
	}

	/*
	 * 
	 *getCategoryList method user for fetching the all the categorys from the database
	 * 
	 */

	@Override
	public List<CategoryDto> getCategoryList() { 
		List<Category> categoryList=     this.categoryRepo.findAll();
		List<CategoryDto> categoryDtoList=	 categoryList.stream().map(category->this.cateoryTodto(category)).collect(Collectors.toList());

		return categoryDtoList;
	}
	
	/*
	 * 
	 * deleteCategory method is used for delete the category from the database
	 * 
	 * 
	 */

	@Override
	public void deleteCategory(Long id) {
		Category category=this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFound("user","user not found",id));
		this.categoryRepo.delete(category);

	}
	
	/*
	 *dtoToCategory method is used for convert the Categorydto object to category
	 * 
	 * 
	 */

	public  Category dtoTocatCategory(CategoryDto categoryDto) {
		Category category=     this.modelMapper.map(categoryDto, Category.class);
		return category;
	}
	/*
	 *dtoToCategory method is used for convert the Categorydto object to category
	 * 
	 * 
	 */


	public CategoryDto cateoryTodto(Category category) {
		CategoryDto  categoryDto=this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
