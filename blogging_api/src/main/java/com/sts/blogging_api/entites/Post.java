package com.sts.blogging_api.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long post_id;
  @Column(nullable = false,length = 100)
	private String title;
  
    private String content;
	private String image;
	private Date date; 
	
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	
}
