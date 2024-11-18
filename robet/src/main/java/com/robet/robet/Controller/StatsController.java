package com.robet.robet.Controller;

import com.robet.robet.DTO.ConfrontoIdDTO;
import com.robet.robet.DTO.StatsDTO;
import com.robet.robet.Model.StatsTeam.StatsTeam;
import com.robet.robet.Model.StatsTeam.StatsTeamRepository;
import com.robet.robet.Service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("stats")
public class StatsController {

    @Autowired
    private StatsTeamRepository repository;
    @Autowired
    private StatsService service;
    @Autowired
    private ConfrontosController confrontosController = new ConfrontosController();


    @GetMapping("/{confrontoId}")
    public StatsDTO.Groups.StatisticsItems.Stats getEscanteiosStats(@PathVariable Integer confrontoId){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<StatsDTO> response = restTemplate.getForEntity("https://www.sofascore.com/api/v1/event/" + confrontoId + "/statistics", StatsDTO.class);
            return response.getBody().groups().get(0).statisticsItems().get(0).stats().get(5);

        }catch (Exception e){
            System.out.println("Erro na requisição de escanteios");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/statsHistorico")
    public void statsTeamHistorico() throws Exception {
        clearStats();
        statsHistorico();
    }

    public void persistStatsTeamList(List<StatsTeam> statsTeamList){
        repository.saveAll(statsTeamList);
    }

    private boolean verificaRodadaPresente(int numeroRodada){
        List<StatsTeam> statsTeamList = repository.findBynumeroRodada(numeroRodada);
        if(statsTeamList.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    private List<StatsTeam> statsTeamRodada(int numeroRodada){
        List<ConfrontoIdDTO.Id> idConfrontoList= confrontosController.getIdConfronto(numeroRodada);
        List<StatsTeam> statsTeamList = new ArrayList<>();
        for(ConfrontoIdDTO.Id confronto : idConfrontoList){
            int idConfronto = confronto.id();
            StatsDTO.Groups.StatisticsItems.Stats statspartida = getEscanteiosStats(idConfronto);
            StatsTeam statsPartidaHome = new StatsTeam(confronto.id(), confronto.homeTeam().shortName(), true, Integer.parseInt(statspartida.home()), numeroRodada);
            StatsTeam statsPartidaAway = new StatsTeam(confronto.id(), confronto.awayTeam().shortName(), false, Integer.parseInt(statspartida.away()), numeroRodada);
            statsTeamList.add(statsPartidaHome);
            statsTeamList.add(statsPartidaAway);
        }
        return statsTeamList;
    }

    private void statsHistorico() throws Exception {
        try{
            int rodadaAtual = confrontosController.getRodadaAtual();
            int rodadasPercorridas = 6;
            boolean fgRodadaVerificada = verificaRodadaPresente(rodadaAtual);
            while(rodadasPercorridas > 0){
                if(!fgRodadaVerificada){
                    persistStatsTeamList(statsTeamRodada(rodadaAtual - rodadasPercorridas));
                    rodadasPercorridas-=1;
                }else{
                    rodadasPercorridas-=1;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Erro ao levantar estatisticas historicas");
        }

    }

    private void clearStats(){
        repository.deleteAll();
    }
}
