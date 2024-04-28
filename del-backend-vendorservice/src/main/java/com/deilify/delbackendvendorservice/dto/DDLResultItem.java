package com.deilify.delbackendvendorservice.dto;

public class DDLResultItem {
	
	private Long id;
	
	private String Key;
	
    private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public DDLResultItem(Long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public DDLResultItem() {
		super();
	}

	@Override
	public String toString() {
		return "DDLResultItem [id=" + id + ", value=" + value + "]";
	}
}
