package com.deilify.delbackendvendorservice.dto;

public class DDLRequestItem {

	private String key;
	
	private Long id;
	
    private String code;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DDLRequestItem(String key, Long id, String code) {
		super();
		this.key = key;
		this.id = id;
		this.code = code;
	}

	public DDLRequestItem() {
		super();
	}

	@Override
	public String toString() {
		return "DDLRequestItem [key=" + key + ", id=" + id + ", code=" + code + "]";
	}

}
