package com.sts.blogging_api.service;

import java.util.List;

import com.sts.blogging_api.payloads.PostDto;
import com.sts.blogging_api.payloads.PostResponse;

public interface PostService {
   
	PostDto createPost(PostDto postTdo,Long user_id,Long category_id);
	PostResponse getAllpost(Integer pageSize,Integer pageNumber);
	PostDto updatePost(PostDto postTdo);
	PostDto getSinglePost(Long id);
   void deletPost(Long id);
   List<PostDto> getAllPostByUser(Long id);
   List<PostDto>getAllPostByCategory(Long id);
	
	
}
