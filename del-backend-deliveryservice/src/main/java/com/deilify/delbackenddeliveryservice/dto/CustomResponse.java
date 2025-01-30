package com.deilify.delbackenddeliveryservice.dto;

import java.util.List;

public class CustomResponse<T> {
	private List<T> content;

    public CustomResponse(List<T> content) {
        this.content = content;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
