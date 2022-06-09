package com.sts.blogging_api.service;

import java.util.ArrayList;
import java.util.List;

import com.sts.blogging_api.payloads.UserDto;

public interface UserService {
    
	UserDto createUser(UserDto userDto) ;
	UserDto updateUser(UserDto userDto,Long id);
	UserDto getUser(Long id);
	List<UserDto> userList();
	void deleteUser(Long id);
	
		

}
