package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deilify.delbackendvendorservice.entity.KycDocumentsEntity;

public interface KycDao extends JpaRepository<KycDocumentsEntity, Long>{

}
