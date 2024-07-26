package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deilify.delbackendvendorservice.entity.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, Integer>{

}
