package com.robet.robet.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConfrontoIdDTO(
        @JsonProperty("events") List<Id> events
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Id(
            @JsonProperty("id") int id
    ) {}
}
