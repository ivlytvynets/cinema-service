package com.dev.theatre.service.impl;

import com.dev.theatre.model.TheatreStage;
import com.dev.theatre.model.dto.TheatreStageRequestDto;
import com.dev.theatre.model.dto.TheatreStageResponseDto;
import com.dev.theatre.service.TheatreStageMapper;
import org.springframework.stereotype.Component;

@Component
public class TheatreStageMapperImpl implements TheatreStageMapper {
    @Override
    public TheatreStageResponseDto getResponseDto(TheatreStage theatreStage) {
        TheatreStageResponseDto theatreStageResponseDto = new TheatreStageResponseDto();
        theatreStageResponseDto.setId(theatreStage.getId());
        theatreStageResponseDto.setCapacity(theatreStage.getCapacity());
        theatreStageResponseDto.setDescription(theatreStage.getDescription());
        return theatreStageResponseDto;
    }

    @Override
    public TheatreStage getEntity(TheatreStageRequestDto theatreStageRequestDto) {
        TheatreStage theatreStage = new TheatreStage();
        theatreStage.setCapacity(theatreStageRequestDto.getCapacity());
        theatreStage.setDescription(theatreStageRequestDto.getDescription());
        return theatreStage;
    }
}
