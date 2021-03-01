package com.dev.theatre.model.dto;

import java.time.LocalDateTime;

public class PerformanceSessionResponseDto {
    private Long performanceSessionId;
    private LocalDateTime showTime;
    private Long performanceId;
    private String performanceTitle;
    private Long theatreStageId;

    public void setPerformanceSessionId(Long performanceSessionId) {
        this.performanceSessionId = performanceSessionId;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public void setTheatreStageId(Long theatreStageId) {
        this.theatreStageId = theatreStageId;
    }
}
