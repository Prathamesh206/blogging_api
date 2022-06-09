package com.sts.blogging_api.payloads;

import java.util.Date;

import com.sts.blogging_api.entites.Category;
import com.sts.blogging_api.entites.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {
	
	private String title;
	private String content;
	private String image;
	
	private Date date;
	private CategoryDto category;
	private UserDto user;

}
