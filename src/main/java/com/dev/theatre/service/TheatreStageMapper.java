package com.dev.theatre.service;

import com.dev.theatre.model.TheatreStage;
import com.dev.theatre.model.dto.TheatreStageRequestDto;
import com.dev.theatre.model.dto.TheatreStageResponseDto;

public interface TheatreStageMapper {
    TheatreStageResponseDto getResponseDto(TheatreStage theatreStage);

    TheatreStage getEntity(TheatreStageRequestDto theatreStageRequestDto);
}
