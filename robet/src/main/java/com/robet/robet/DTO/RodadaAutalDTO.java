package com.robet.robet.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RodadaAutalDTO(@JsonProperty("rounds") List<Round> rounds) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Round(@JsonProperty("roundId") Integer roundId){}
}
