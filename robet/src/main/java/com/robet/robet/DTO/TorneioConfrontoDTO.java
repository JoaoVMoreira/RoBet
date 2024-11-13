package com.robet.robet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TorneioConfrontoDTO(
        @JsonProperty("tournament") List<ConfrontoIdDTO> torneios
        ){}
