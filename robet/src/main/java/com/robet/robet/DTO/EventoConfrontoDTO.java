package com.robet.robet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record EventoConfrontoDTO(
        @JsonProperty("events") List<TorneioConfrontoDTO> torneios
){}
