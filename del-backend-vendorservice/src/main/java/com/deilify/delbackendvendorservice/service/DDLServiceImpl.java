package com.deilify.delbackendvendorservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deilify.delbackendvendorservice.dao.CategoryDao;
import com.deilify.delbackendvendorservice.dao.ServiceLineDao;
import com.deilify.delbackendvendorservice.dao.SubCategoryDao;
import com.deilify.delbackendvendorservice.dto.DDLResultItem;
import com.deilify.delbackendvendorservice.dto.RequestPayload;
import com.deilify.delbackendvendorservice.entity.CategoryEntity;
import com.deilify.delbackendvendorservice.entity.ServiceLineEntity;
import com.deilify.delbackendvendorservice.entity.SubCategoryEntity;

@Service
public class DDLServiceImpl implements DDLService{

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SubCategoryDao subCategoryDao;
	
	@Autowired
	ServiceLineDao serviceLineDao;
	
	@Override
	public List<DDLResultItem> getDDLResults(RequestPayload requestPayload) {
		List<DDLResultItem> ddlResultItemList = new ArrayList<DDLResultItem>();
		
		
		if(requestPayload.getRequestDDL().get(0).getKey().equalsIgnoreCase("category") && isNullBlankEmpty(requestPayload.getRequestDDL().get(0).getCode())) {
			List<CategoryEntity> entity = categoryDao.findAll();
			for (CategoryEntity categoryEntity : entity) {
				DDLResultItem ddlResultItem = new DDLResultItem();
				ddlResultItem.setKey("category");
				ddlResultItem.setId(categoryEntity.getId());
				ddlResultItem.setValue(categoryEntity.getValue());
				ddlResultItemList.add(ddlResultItem);
			}
		}else if (requestPayload.getRequestDDL().get(0).getKey().equalsIgnoreCase("category") && !isNullBlankEmpty(requestPayload.getRequestDDL().get(0).getCode())) {
			List<SubCategoryEntity> entity = subCategoryDao.findSubCategoryByCategoryCode(requestPayload.getRequestDDL().get(0).getCode());
			for (SubCategoryEntity subCategoryEntity : entity) {
				DDLResultItem ddlResultItem = new DDLResultItem();
				ddlResultItem.setKey("subCategory");
				ddlResultItem.setId(subCategoryEntity.getId());
				ddlResultItem.setValue(subCategoryEntity.getValue());
				ddlResultItemList.add(ddlResultItem);
			}
		}else if (requestPayload.getRequestDDL().get(0).getKey().equalsIgnoreCase("sub_category") && !isNullBlankEmpty(requestPayload.getRequestDDL().get(0).getCode())) {
			List<ServiceLineEntity> entity = serviceLineDao.findServiceBySubCategoryCode(requestPayload.getRequestDDL().get(0).getId(),requestPayload.getRequestDDL().get(0).getCode());
			for (ServiceLineEntity serviceLineEntity : entity) {
				DDLResultItem ddlResultItem = new DDLResultItem();
				ddlResultItem.setKey("serviceLine");
				ddlResultItem.setId(serviceLineEntity.getId());
				ddlResultItem.setValue(serviceLineEntity.getValue());
				ddlResultItemList.add(ddlResultItem);
			}
		}
		return ddlResultItemList;
	}
	private boolean isNullBlankEmpty(String str) {
		return str == null || str.isEmpty() || str.isBlank();
	}

}
