package com.deilify.delbackendvendorservice.controller;
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

import com.deilify.delbackendvendorservice.service.ServiceControllerService;

//Controller
@RestController
@RequestMapping("/api/files/bulkUpload")
class ServiceController {

	@Autowired
	ServiceControllerService serviceControllerService;
    

	@PostMapping("/ServiceUpload")
	public ResponseEntity<String> uploadServiceFile(@RequestParam("file") MultipartFile file,
			@RequestParam("vendor_id") Integer vendorId) {
		try {
			serviceControllerService.saveServicesFromExcel(file, vendorId);
			return ResponseEntity.ok("File uploaded and data inserted successfully");
		} catch (MaxUploadSizeExceededException e) {
			return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
					.body("File size exceeds the maximum limit of 10MB.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error processing file: " + e.getMessage());
		}
	}
	
	@GetMapping("/ServiceDownload")
    public ResponseEntity<Resource> downloadTemplate() {
        try {
            return serviceControllerService.downloadTemplate();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
}
