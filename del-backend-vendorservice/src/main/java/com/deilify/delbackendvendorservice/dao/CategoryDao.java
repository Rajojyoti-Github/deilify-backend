package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deilify.delbackendvendorservice.entity.CategoryEntity;
@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer>{

}
