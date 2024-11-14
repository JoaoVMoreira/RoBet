package com.robet.robet.Controller;

import com.robet.robet.DTO.StatsEscanteiosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("escanteios")
public class EscanteiosController {

    @GetMapping("/{confrontoId}")
        public StatsEscanteiosDTO.Groups.StatisticsItems.Stats getEscanteiosStats(@PathVariable Integer confrontoId){
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<StatsEscanteiosDTO> response = restTemplate.getForEntity("https://www.sofascore.com/api/v1/event/" + confrontoId + "/statistics", StatsEscanteiosDTO.class);
            return response.getBody().groups().get(0).statisticsItems().get(0).stats().get(5);

        }catch (Exception e){
            System.out.println("Erro na requisição de escanteios");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
