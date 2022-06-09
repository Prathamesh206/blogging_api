package com.sts.blogging_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.blogging_api.entites.Category;
import com.sts.blogging_api.entites.Post;
import com.sts.blogging_api.entites.User;

public interface PostRepo extends JpaRepository<Post, Long>{
	  
	List<Post> findByUser(User user);
	List<Post> findByCategory (Category category);

}
