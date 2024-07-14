package com.deilify.delbackendvendorservice.dto;

import java.util.List;

public class RequestPayload {
	
    private List<DDLRequestItem> requestDDL;

	public List<DDLRequestItem> getRequestDDL() {
		return requestDDL;
	}

	public void setRequestDDL(List<DDLRequestItem> requestDDL) {
		this.requestDDL = requestDDL;
	}

	public RequestPayload(List<DDLRequestItem> requestDDL) {
		super();
		this.requestDDL = requestDDL;
	}

	public RequestPayload() {
		super();
	}

	@Override
	public String toString() {
		return "RequestPayload [requestDDL=" + requestDDL + "]";
	}
    
}