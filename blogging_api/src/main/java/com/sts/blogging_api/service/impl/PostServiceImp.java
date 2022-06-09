package com.sts.blogging_api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sts.blogging_api.entites.Category;
import com.sts.blogging_api.entites.Post;
import com.sts.blogging_api.entites.User;
import com.sts.blogging_api.exception.ResourceNotFound;
import com.sts.blogging_api.payloads.PostDto;
import com.sts.blogging_api.payloads.PostResponse;
import com.sts.blogging_api.repositories.CategoryRepo;
import com.sts.blogging_api.repositories.PostRepo;
import com.sts.blogging_api.repositories.UserRepo;
import com.sts.blogging_api.service.PostService;

@Service
public class PostServiceImp implements PostService {
	@Autowired
	PostRepo postRepo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CategoryRepo categoryRepo;



	@Override 
	public PostDto createPost(PostDto postTdo,Long user_id,Long category_id) {
		Post post=   this.modelMapper.map(postTdo,Post.class);
		post.setImage("degault.png");
		post.setDate(new Date());
		User user=      this.userRepo.findById(user_id).orElseThrow(()->new ResourceNotFound("user","user not found", user_id));
		Category category=this.categoryRepo.findById(category_id).orElseThrow(()->new ResourceNotFound("category", "category not found", category_id));
        post.setCategory(category);
        post.setUser(user);
       Post post1= this.postRepo.save(post);
       return this.modelMapper.map(post1, PostDto.class);
	}

	@Override
	public PostResponse getAllpost(Integer pageNumber,Integer pageSize) {
		
		     Pageable p= PageRequest.of(pageSize, pageNumber);
		      Page<Post> Allpost=  this.postRepo.findAll(p);
		         List<Post> postList=Allpost.getContent();
		         
		         List<PostDto> postDtoList= postList.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		         PostResponse postResponse=new PostResponse();
		         postResponse.setPostList(postDtoList);
		         postResponse.setLastPage(Allpost.isLast());
		         postResponse.setPageSize(Allpost.getNumber());
		    return  postResponse;
	       
	}

	@Override
	public PostDto updatePost(PostDto postTdo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getSinglePost(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletPost(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPostByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPostByCategory(Long id) {
	Category category=	    this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFound("category", "category not found", id));
	   List<Post> postList= this.postRepo.findByCategory(category);
	List<PostDto>  postDtoList=  postList.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	return postDtoList;
	}

}
