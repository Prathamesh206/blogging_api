package com.sts.blogging_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.blogging_api.entites.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {

}
