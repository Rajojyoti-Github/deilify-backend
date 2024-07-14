package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deilify.delbackendvendorservice.entity.ServicesEntity;

public interface ServicesDao extends JpaRepository<ServicesEntity, Integer>{

}
