package com.robet.robet.Model.StatsTeam;


import com.robet.robet.DTO.StatsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "statsTeam")
@Entity(name = "statsTeam")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatsTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int confrontoId;
    private String teamName;
    private Boolean fgHome;
    private int escanteios;
    private int numeroRodada;

    public StatsTeam(int confrontoId, String teamName, Boolean fgHome, int escanteios, int numeroRodada){
        this.confrontoId = confrontoId;
        this.teamName = teamName;
        this.fgHome = fgHome;
        this.escanteios = escanteios;
        this.numeroRodada = numeroRodada;
    }
}
