package com.sts.blogging_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sts.blogging_api.config.AppConstatant;
import com.sts.blogging_api.payloads.PostDto;
import com.sts.blogging_api.payloads.PostResponse;
import com.sts.blogging_api.service.impl.PostServiceImp;

@RestController
@RequestMapping("/Api/")
public class PostController {
	@Autowired
	PostServiceImp postServiceImpl;
	
	@PostMapping("/User/{userId}/Category/{categoryId}/Post")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Long userId,@PathVariable Long  categoryId){
		PostDto postDto1= this.postServiceImpl.createPost(postDto, userId, categoryId);
    	
		return new ResponseEntity<PostDto>(postDto1,HttpStatus.CREATED);
    }
	
	@GetMapping("category/{categoryId}/Post")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Long categoryId){
	List<PostDto> postList=	this.postServiceImpl.getAllPostByCategory(categoryId);
	return new ResponseEntity<List<PostDto>>(postList,HttpStatus.OK);
		
	}
	
	@GetMapping("/post")
	public ResponseEntity<PostResponse>  getAllPost(@RequestParam(value = "pageNumber", defaultValue = AppConstatant.PAGE_NUMBER,required=false) Integer pageNumber,@RequestParam(value = "pageSize",defaultValue =AppConstatant.PAGE_SIZE,required=false)Integer pageSize){
		PostResponse  postList=this.postServiceImpl.getAllpost(pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(postList,HttpStatus.OK);
		
	}
		
	}


