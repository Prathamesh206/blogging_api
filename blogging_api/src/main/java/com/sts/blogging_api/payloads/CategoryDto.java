package com.sts.blogging_api.payloads;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
 private Long cat_id;
 private String title;
 private String description;
}
