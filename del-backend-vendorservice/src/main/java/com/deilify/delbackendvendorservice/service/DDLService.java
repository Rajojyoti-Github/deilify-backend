package com.deilify.delbackendvendorservice.service;

import java.util.List;

import com.deilify.delbackendvendorservice.dto.DDLResultItem;
import com.deilify.delbackendvendorservice.dto.RequestPayload;

public interface DDLService {

	List<DDLResultItem> getDDLResults(RequestPayload requestPayload);

}
