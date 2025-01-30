package com.deilify.delbackendvendorservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deilify.delbackendvendorservice.entity.FileMetadata;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
}