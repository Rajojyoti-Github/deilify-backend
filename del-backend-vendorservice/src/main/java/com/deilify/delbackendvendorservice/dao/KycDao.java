package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deilify.delbackendvendorservice.entity.KycDocumentsEntity;

@Repository
public interface KycDao extends JpaRepository<KycDocumentsEntity, Long>{

}
