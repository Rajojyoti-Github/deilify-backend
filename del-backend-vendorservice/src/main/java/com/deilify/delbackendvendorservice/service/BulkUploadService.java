package com.deilify.delbackendvendorservice.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BulkUploadService {
	
    void saveServicesFromExcel(MultipartFile file, Integer vendorId) throws IOException;
    ResponseEntity<Resource> downloadGenericTemplate() throws IOException;
    
}
