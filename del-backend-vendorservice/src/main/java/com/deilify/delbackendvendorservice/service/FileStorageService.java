package com.deilify.delbackendvendorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.deilify.delbackendvendorservice.dao.KycDao;
import com.deilify.delbackendvendorservice.dto.BusinessTypeDto;
import com.deilify.delbackendvendorservice.dto.FileStorageProperties;
import com.deilify.delbackendvendorservice.entity.KycDocumentsEntity;
import com.deilify.delbackendvendorservice.exception.FileStorageException;
import com.deilify.delbackendvendorservice.exception.MyFileNotFoundException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    
    @Autowired
    KycDao kycDao;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file, BusinessTypeDto businessType) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        KycDocumentsEntity entity = new KycDocumentsEntity();
        entity.setVendorId(businessType.getVendorId());
        entity.setVendorName(businessType.getVendorName());
        entity.setTypeOfBusiness(businessType.getTypeOfBusiness());
        entity.setFileName(fileName);
        entity.setCreatedTimestamp(LocalDate.now());
        entity.setUpdatedTimestamp(LocalDate.now());

        kycDao.save(entity);
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
