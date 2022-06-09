package com.sts.blogging_api.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Long cat_id;
	@Column(nullable = false,length = 100)
  private String title;
	
  private String description;
  
  @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
  private List<Post> post=new ArrayList<>();
  
  
}
