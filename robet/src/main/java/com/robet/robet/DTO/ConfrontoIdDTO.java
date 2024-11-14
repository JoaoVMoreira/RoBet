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
            @JsonProperty("id") int id,
            @JsonProperty("homeTeam") Team homeTeam,
            @JsonProperty("awayTeam") Team awayTeam,
            @JsonProperty("status") Status status
    ){}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Team(@JsonProperty("shortName") String shortName){}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Status(@JsonProperty("code") Integer code){}
}
