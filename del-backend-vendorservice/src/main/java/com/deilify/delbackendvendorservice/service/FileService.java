package com.deilify.delbackendvendorservice.service;

import org.springframework.web.multipart.MultipartFile;

import com.deilify.delbackendvendorservice.dto.FileMetadataDTO;

public interface FileService {
	FileMetadataDTO saveFile(MultipartFile file, String category, Long vendorId, String vendorName, String typeOfBusiness);
}
