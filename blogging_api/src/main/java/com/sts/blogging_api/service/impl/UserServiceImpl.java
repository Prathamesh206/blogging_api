package com.sts.blogging_api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.blogging_api.entites.User;
import com.sts.blogging_api.exception.ResourceNotFound;
import com.sts.blogging_api.payloads.UserDto;
import com.sts.blogging_api.repositories.UserRepo;
import com.sts.blogging_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=         this.dtoToUser(userDto);
		User savedUser       =  this.userRepo.save(user);
		return this.userTodto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		User user=  this.userRepo.findById(id).orElseThrow(()->new ResourceNotFound("user","user not found",id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser=this.userRepo.save(user);
		return this.userTodto(updateUser);
	}

	@Override
	public UserDto getUser(Long id) {

		User user=  this.userRepo.findById(id).orElseThrow(()->new ResourceNotFound("user","user not found",id));
		return this.userTodto(user);
	}


	@Override
	public List<UserDto> userList() {
		List<User> userList=this.userRepo.findAll();
		List<UserDto> UserDtoList=		userList.stream().map(user-> this.userTodto(user)).collect(Collectors.toList());
		return UserDtoList;
	}

	@Override
	public void deleteUser(Long id) {
		User user=	this.userRepo.findById(id).orElseThrow(()->new ResourceNotFound("user","user not found",id));
		this.userRepo.delete(user);

	}

	public User dtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		//	    user.setId(userDto.getId());
		//	    user.setName(userDto.getName());
		//	    user.setEmail(userDto.getEmail());
		//	    user.setPassword(userDto.getPassword());
		//	    user.setAbout(userDto.getAbout());
		return user;


	}

	public UserDto userTodto(User user) {
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		//		userDto.setId(user.getId());
		//		userDto.setName(user.getName());
		//		userDto.setEmail(user.getEmail());
		//		userDto.setPassword(user.getPassword());
		//		userDto.setAbout(user.getAbout());
		return userDto;

	}

}
