package com.sts.blogging_api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.blogging_api.entites.User;
import com.sts.blogging_api.payloads.ApiResponse;
import com.sts.blogging_api.payloads.UserDto;
import com.sts.blogging_api.service.impl.UserServiceImpl;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;
	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid@RequestBody UserDto userDto) {
		UserDto userDto1=this.userServiceImpl.createUser(userDto);
		return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
	}
	 
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getUserList(){
		
		     List<UserDto> userList= this.userServiceImpl.userList();
			return new ResponseEntity<List<UserDto>>(userList,HttpStatus.OK);
		     
	} 
  @PutMapping("/{id}")
  
  public ResponseEntity<UserDto> updateUser(@Valid@RequestBody UserDto userDto,@PathVariable Long id){
	        UserDto userDto1=  this.userServiceImpl.updateUser(userDto, id);
	       
	  
	   
	   
	          return new ResponseEntity<>(userDto1,HttpStatus.ACCEPTED);
	  
	  
  }
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUser(@PathVariable Long id){
	            UserDto userDto =this.userServiceImpl.getUser(id);
	            return ResponseEntity.ok(userDto);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable Long id){
	                  this.userServiceImpl.deleteUser(id);
	              return new  ResponseEntity<>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
  }
}
