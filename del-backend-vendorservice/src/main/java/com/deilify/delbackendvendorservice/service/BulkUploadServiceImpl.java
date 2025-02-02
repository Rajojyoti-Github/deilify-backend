package com.deilify.delbackendvendorservice.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.deilify.delbackendvendorservice.dao.ServicesDao;
import com.deilify.delbackendvendorservice.dao.VendorCreateDao;
import com.deilify.delbackendvendorservice.entity.ServicesEntity;
import com.deilify.delbackendvendorservice.entity.VendorEntity;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

@Service
public class BulkUploadServiceImpl implements BulkUploadService{

	@Autowired
	VendorCreateDao vendorDao;

	@Autowired
	private ServicesDao servicesDao;
    
    @Autowired
    private S3Client s3Client;

    @Value("${environment.type}")
    private String environmentType;

    @Value("${s3.bucket.name}")
    private String bucketName;

    @Value("${s3.key}")
    private String s3Key;

    @Value("${local.template.path}")
    private String localTemplatePath;

	public void saveServicesFromExcel(MultipartFile file, Integer vendorId) throws IOException {
		List<ServicesEntity> services = new ArrayList<>();
		VendorEntity entity = vendorDao.findById(vendorId).get();
		try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				if (row.getRowNum() == 0)
					continue; // Skip header

				if (row.getCell(0) != null && !row.getCell(0).getStringCellValue().trim().isEmpty() &&
		                row.getCell(1) != null && !row.getCell(1).getStringCellValue().trim().isEmpty() &&
		                row.getCell(2) != null && !row.getCell(2).getStringCellValue().trim().isEmpty() &&
		                row.getCell(3) != null && row.getCell(3).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC &&
		                row.getCell(3).getNumericCellValue() > 0) {

					ServicesEntity service = new ServicesEntity();
					service.setVendorId(vendorId);
					service.setNameOfVendor(entity.getNameOfVendor());
					service.setCategory(row.getCell(0).getStringCellValue());
					service.setVendorStoreId("1");
					service.setSubCategory(row.getCell(1).getStringCellValue());
					service.setServiceLine(row.getCell(2).getStringCellValue());
					service.setPrice(BigDecimal.valueOf(row.getCell(3).getNumericCellValue()));
					service.setCreatedTimestamp(LocalDateTime.now());
					service.setUpdatedTimestamp(LocalDateTime.now());

					services.add(service);
				}
			}
		}

		servicesDao.saveAll(services);
	}
	
	public ResponseEntity<Resource> downloadGenericTemplate() throws IOException {
        Path filePath;
        if ("aws".equalsIgnoreCase(environmentType)) {
            // Download from S3 if the environment is AWS
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(s3Key)
                    .build();
            ResponseInputStream<?> s3Object = s3Client.getObject(getObjectRequest);
            filePath = Paths.get("temp-template.xlsx");
            Files.copy(s3Object, filePath, StandardCopyOption.REPLACE_EXISTING);
        } else {
            // Use the local template if environment is local
            filePath = Paths.get(localTemplatePath);
        }

        Resource resource = new UrlResource(filePath.toUri());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=template.xlsx")
                .body(resource);
    }
	
}
