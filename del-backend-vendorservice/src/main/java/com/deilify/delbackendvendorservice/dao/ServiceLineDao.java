package com.deilify.delbackendvendorservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deilify.delbackendvendorservice.entity.ServiceLineEntity;

@Repository
public interface ServiceLineDao extends JpaRepository<ServiceLineEntity, Integer>{

	@Query(value = "SELECT serviceLine.* FROM deilify.service_line serviceLine join deilify.sub_category subCategory on subCategory.id=serviceLine.sub_category_id where subCategory.value= :code  and serviceLine.sub_category_id= :subCategoryId", nativeQuery = true)
	List<ServiceLineEntity> findServiceBySubCategoryCode(@Param("subCategoryId") Long subCategoryId, @Param("code") String code);

}
