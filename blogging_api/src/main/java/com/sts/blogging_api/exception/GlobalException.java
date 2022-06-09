package com.sts.blogging_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sts.blogging_api.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFound ex){
		String message=ex.getMessage();
		ApiResponse response=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String,String>> methodArgumentException(MethodArgumentNotValidException ex){
//		Map<String,String> resp=new HashMap();
//		ex.getBindingResult().getAllErrors().forEach((error)->{
//			String message=error.getDefaultMessage();
//			               error.
//		});
//		return null;
//	 
//		
//	}
}
