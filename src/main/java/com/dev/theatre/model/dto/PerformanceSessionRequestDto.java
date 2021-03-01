package com.dev.theatre.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerformanceSessionRequestDto {
    @NotNull
    private LocalDateTime showTime;
    @NotNull
    private Long performanceId;
    @NotNull
    private Long theatreStageId;

    public Long getPerformanceId() {
        return performanceId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public Long getTheatreStageId() {
        return theatreStageId;
    }
}
