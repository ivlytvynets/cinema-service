package com.dev.theatre.model.dto;

public class PerformanceResponseDto {
    private Long id;
    private String title;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
