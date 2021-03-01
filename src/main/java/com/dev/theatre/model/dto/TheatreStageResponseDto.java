package com.dev.theatre.model.dto;

public class TheatreStageResponseDto {
    private Long id;
    private int capacity;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
