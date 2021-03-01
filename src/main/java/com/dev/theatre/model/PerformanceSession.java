package com.dev.theatre.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "performance_session")
public class PerformanceSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime showTime;
    @ManyToOne
    @JoinColumn(name = "performance_id")
    private Performance performance;
    @ManyToOne
    @JoinColumn(name = "theatre_stage_id")
    private TheatreStage theatreStage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public TheatreStage getTheatreStage() {
        return theatreStage;
    }

    public void setTheatreStage(TheatreStage theatreStage) {
        this.theatreStage = theatreStage;
    }

    @Override
    public String toString() {
        return "PerformanceSession{"
                + "id=" + id
                + ", showTime=" + showTime
                + ", performance=" + performance
                + ", theatreStage=" + theatreStage
                + '}';
    }
}
