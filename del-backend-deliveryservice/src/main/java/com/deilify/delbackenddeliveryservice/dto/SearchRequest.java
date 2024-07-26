package com.deilify.delbackenddeliveryservice.dto;

import java.util.List;

public class SearchRequest {
	
	   private List<DeliveryDTO> services;
	   private int page;
	   private int size;
	public List<DeliveryDTO> getServices() {
		return services;
	}
	public void setServices(List<DeliveryDTO> services) {
		this.services = services;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public SearchRequest(List<DeliveryDTO> services, int page, int size) {
		super();
		this.services = services;
		this.page = page;
		this.size = size;
	}
	@Override
	public String toString() {
		return "SearchRequest [services=" + services + ", page=" + page + ", size=" + size + "]";
	}
	
	   
	   
}
