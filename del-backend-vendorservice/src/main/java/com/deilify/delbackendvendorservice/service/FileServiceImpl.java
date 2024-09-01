package com.deilify.delbackendvendorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deilify.delbackendvendorservice.dao.FileMetadataRepository;
import com.deilify.delbackendvendorservice.dto.FileMetadataDTO;
import com.deilify.delbackendvendorservice.entity.FileMetadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    private final String rootDirectory = "uploads/";

    @Override
    public FileMetadataDTO saveFile(MultipartFile file, String category, Long vendorId, String vendorName, String typeOfBusiness) {
        try {
            // Create directory based on category
            String directory = rootDirectory + category;
            Files.createDirectories(Paths.get(directory));

            // Determine file path
            Path filePath = Paths.get(directory, file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            // Save metadata to the database
            FileMetadata metadata = new FileMetadata();
            metadata.setVendorId(vendorId);
            metadata.setVendorName(vendorName);
            metadata.setTypeOfBusiness(typeOfBusiness);
            metadata.setFileName(file.getOriginalFilename());
            metadata.setCreatedTimestamp(LocalDate.now());
            metadata.setUpdatedTimestamp(LocalDate.now());
            metadata.setFilePath(filePath.toString());
            metadata.setFileType(file.getContentType());
            metadata.setFileSize(file.getSize());
            metadata.setCategory(category);

            FileMetadata savedMetadata = fileMetadataRepository.save(metadata);

            // Convert entity to DTO
            FileMetadataDTO fileMetadataDTO = new FileMetadataDTO();
            fileMetadataDTO.setId(savedMetadata.getId());
            fileMetadataDTO.setVendorId(savedMetadata.getVendorId());
            fileMetadataDTO.setVendorName(savedMetadata.getVendorName());
            fileMetadataDTO.setTypeOfBusiness(savedMetadata.getTypeOfBusiness());
            fileMetadataDTO.setFileName(savedMetadata.getFileName());
            fileMetadataDTO.setCreatedTimestamp(savedMetadata.getCreatedTimestamp());
            fileMetadataDTO.setUpdatedTimestamp(savedMetadata.getUpdatedTimestamp());
            fileMetadataDTO.setFilePath(savedMetadata.getFilePath());
            fileMetadataDTO.setFileType(savedMetadata.getFileType());
            fileMetadataDTO.setFileSize(savedMetadata.getFileSize());
            fileMetadataDTO.setCategory(savedMetadata.getCategory());

            return fileMetadataDTO;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
