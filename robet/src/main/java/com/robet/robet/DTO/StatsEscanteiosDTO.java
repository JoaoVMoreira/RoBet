package com.robet.robet.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StatsEscanteiosDTO(
        @JsonProperty("statistics") List<Groups> groups
){
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Groups(@JsonProperty("groups") List<StatisticsItems> statisticsItems){
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record StatisticsItems(@JsonProperty("statisticsItems") List<Stats> stats){
            public record Stats(
                @JsonProperty("name") String name,
                @JsonProperty("home") String home,
                @JsonProperty("away") String away
            ){}
        }
    }
}


/*

* */