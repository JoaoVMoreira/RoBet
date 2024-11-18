package com.robet.robet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StatsFinalDTO(@JsonProperty("stats") Stats stats) {
    public record Stats(
            @JsonProperty("homeTeam") HomeTeam homeTeam,
            @JsonProperty("awayTeam") AwayTeam awayTeam
    ){
        public record HomeTeam(
                @JsonProperty("shortName") String shortName,
                @JsonProperty("medEscanteiosPJ") Float medEscanteiosPJ,
                @JsonProperty("maxEscanteiosPJ") Integer maxEscanteiosPJ,
                @JsonProperty("minEscanteiosPJ") Integer minEscanteiosPJ
        ){}
        public record AwayTeam(
                @JsonProperty("shortName") String shortName,
                @JsonProperty("medEscanteiosPJ") Float medEscanteiosPJ,
                @JsonProperty("maxEscanteiosPJ") Integer maxEscanteiosPJ,
                @JsonProperty("minEscanteiosPJ") Integer minEscanteiosPJ
        ){}
    }
}
