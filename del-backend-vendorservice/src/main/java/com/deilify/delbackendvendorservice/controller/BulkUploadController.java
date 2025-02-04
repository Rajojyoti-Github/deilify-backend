package com.deilify.delbackendvendorservice.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.deilify.delbackendvendorservice.dto.ApiResponse;
import com.deilify.delbackendvendorservice.service.BulkUploadServiceImpl;

//Controller
@RestController
@RequestMapping("/api/files/bulkUpload")
class BulkUploadController {

	@Autowired
	BulkUploadServiceImpl bulkUploadImpl;
    

	@PostMapping("/ServiceUpload")
	public ResponseEntity<ApiResponse> uploadServiceFile(@RequestParam("file") MultipartFile file,
	        @RequestParam("vendor_id") Integer vendorId) {
	    try {
	        bulkUploadImpl.saveServicesFromExcel(file, vendorId);
	        return ResponseEntity.ok(new ApiResponse("File uploaded and data inserted successfully", 200));
	    } catch (MaxUploadSizeExceededException e) {
	        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
	                .body(new ApiResponse("File size exceeds the maximum limit of 10MB.", HttpStatus.PAYLOAD_TOO_LARGE.value()));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ApiResponse("Error processing file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
	    }
	}


	
	@GetMapping("/ServiceDownload")
    public ResponseEntity<Resource> downloadGenericTemplate() {
        try {
            return bulkUploadImpl.downloadGenericTemplate();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
}
