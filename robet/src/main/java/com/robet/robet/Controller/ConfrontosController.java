package com.robet.robet.Controller;


import com.robet.robet.DTO.ConfrontoIdDTO;
import com.robet.robet.DTO.RodadaAutalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("confrontos")
public class ConfrontosController {

    @GetMapping("/{rodadaId}")
    public List<ConfrontoIdDTO.Id> getIdConfronto(@PathVariable Integer rodadaId){
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<ConfrontoIdDTO> response = restTemplate.getForEntity("https://www.sofascore.com/api/v1/unique-tournament/325/season/58766/events/round/" + rodadaId, ConfrontoIdDTO.class);
            return response.getBody().events();
        }catch (Exception e){
            System.out.println("Erro na requisição do idConfronto");
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/rodada-atual")
    public Integer getRodadaAtual(){
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<RodadaAutalDTO> response = restTemplate.getForEntity("https://www.sofascore.com/api/v1/unique-tournament/325/season/58766/team-of-the-week/rounds", RodadaAutalDTO.class);
            return response.getBody().rounds().size() + 1;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Erro ao localizar numero da rodada atual");
            return null;
        }
    }
}
