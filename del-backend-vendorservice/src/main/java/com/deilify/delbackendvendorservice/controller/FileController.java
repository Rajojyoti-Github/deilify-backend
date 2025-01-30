package com.deilify.delbackendvendorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.deilify.delbackendvendorservice.dto.FileMetadataDTO;
import com.deilify.delbackendvendorservice.service.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileMetadataDTO> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("category") String category,
            @RequestParam("vendorId") Long vendorId,
            @RequestParam("vendorName") String vendorName,
            @RequestParam("typeOfBusiness") String typeOfBusiness) {

        FileMetadataDTO fileMetadataDTO = fileService.saveFile(file, category, vendorId, vendorName, typeOfBusiness);

        if (fileMetadataDTO != null) {
            return ResponseEntity.ok(fileMetadataDTO);
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
