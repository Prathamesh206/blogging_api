package com.sts.blogging_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.blogging_api.payloads.ApiResponse;
import com.sts.blogging_api.payloads.CategoryDto;

import com.sts.blogging_api.service.impl.CategoryServiceImpl;


@RestController
@RequestMapping("/api/category")
public class Categorycontroller {
	
   @Autowired
	CategoryServiceImpl categoryServiceImpl;
   @PostMapping("/")
   public ResponseEntity<CategoryDto> createcategory(@RequestBody CategoryDto categoryDto){
	      CategoryDto  categoryDto2=  this.categoryServiceImpl.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(categoryDto2,HttpStatus.CREATED);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable long id){
	     CategoryDto catDto        =  this.categoryServiceImpl.updateCategory(categoryDto, id);
		return new ResponseEntity<CategoryDto>(catDto,HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id){
	     CategoryDto catDto = this.categoryServiceImpl.getCategory(id);
	     return new ResponseEntity<CategoryDto>(catDto,HttpStatus.OK);
	     
   }
   
   @GetMapping("/")
   public ResponseEntity<List<CategoryDto>> getCategoryist(){
	  
	     List<CategoryDto>  cateList = this.categoryServiceImpl.getCategoryList();
	     return new ResponseEntity<List<CategoryDto>>(cateList,HttpStatus.OK);
   }
	 @DeleteMapping("/{id}")    
	 public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Long id){
		     this.categoryServiceImpl.deleteCategory(id);
		     return new ResponseEntity<ApiResponse>(new ApiResponse("user Deleted successfully",true),HttpStatus.OK);
	 }
	     
	
	   
   }

