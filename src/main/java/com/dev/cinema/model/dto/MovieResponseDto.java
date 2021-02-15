package com.dev.cinema.model.dto;

public class MovieResponseDto {
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
