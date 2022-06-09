package com.sts.blogging_api.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;


@Data

public class UserDto {
  private Long id;
  @NotNull
  @Size(min = 3,message = "name not be more thean 10 character")
  private  String name;
  @Email
  private String email;
  @NotNull
  @Size(min = 6,max = 10,message = "password should be grater than 3 character and  less than 10 character")

  private String password;
  private String about;
  
}
