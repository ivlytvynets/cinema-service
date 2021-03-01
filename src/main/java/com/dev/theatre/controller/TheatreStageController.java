package com.dev.theatre.controller;

import com.dev.theatre.model.TheatreStage;
import com.dev.theatre.model.dto.TheatreStageRequestDto;
import com.dev.theatre.model.dto.TheatreStageResponseDto;
import com.dev.theatre.service.TheatreStageMapper;
import com.dev.theatre.service.TheatreStageService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre-stages")
public class TheatreStageController {
    private final TheatreStageMapper theatreStageMapper;
    private final TheatreStageService theatreStageService;

    public TheatreStageController(TheatreStageMapper theatreStageMapper,
                                  TheatreStageService theatreStageService) {
        this.theatreStageMapper = theatreStageMapper;
        this.theatreStageService = theatreStageService;
    }

    @GetMapping
    public List<TheatreStageResponseDto> getAll() {
        List<TheatreStage> theatreStages = theatreStageService.getAll();
        return theatreStages
                .stream()
                .map(theatreStageMapper::getResponseDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void add(@RequestBody @Valid TheatreStageRequestDto theatreStageRequestDto) {
        TheatreStage theatreStage = theatreStageMapper.getEntity(theatreStageRequestDto);
        theatreStageService.add(theatreStage);
    }
}
