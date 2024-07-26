/**
 * 
 */
package com.deilify.delbackenduserservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deilify.delbackenduserservice.entity.UserEntity;

/**
 * @author user
 *
 */
public interface UserCreateDao extends JpaRepository<UserEntity, Integer> {
	
	@Query(value = "Select * from deilify.user u where u.username = :phone", nativeQuery = true)
	UserEntity findByUserName(@Param("phone") String phone);

}
