package com.deilify.delbackendvendorservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deilify.delbackendvendorservice.entity.SubCategoryEntity;

@Repository
public interface SubCategoryDao extends JpaRepository<SubCategoryEntity, Integer>{

	@Query(value = "SELECT subCategory.* FROM deilify.sub_category subCategory join deilify.category category on category.id=subCategory.category_id where category.value= :code", nativeQuery = true)
	List<SubCategoryEntity> findSubCategoryByCategoryCode(@Param("code") String code);

}
