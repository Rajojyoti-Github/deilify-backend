package com.deilify.delbackendvendorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deilify.delbackendvendorservice.dto.DDLResultItem;
import com.deilify.delbackendvendorservice.dto.RequestPayload;
import com.deilify.delbackendvendorservice.service.DDLService;

@RestController
@RequestMapping(value = "/api")
public class DDLController {

	@Autowired
	DDLService ddlService;
	
	@PostMapping("/getDDLResults")
    public List<DDLResultItem> getDDLResults(@RequestBody RequestPayload requestPayload) {
        return ddlService.getDDLResults(requestPayload);
    }
	
}
