package com.deilify.delbackendvendorservice.dto;

import java.util.List;

public class SearchCriteria {
	
	    private List<ServicesDTO> services;
	    private int page;
	    private int size;
		public List<ServicesDTO> getServices() {
			return services;
		}
		public void setServices(List<ServicesDTO> services) {
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
		public SearchCriteria() {
			super();
		}
		public SearchCriteria(List<ServicesDTO> services, int page, int size) {
			super();
			this.services = services;
			this.page = page;
			this.size = size;
		}
		@Override
		public String toString() {
			return "SearchCriteria [services=" + services + ", page=" + page + ", size=" + size + "]";
		}
	    
}
