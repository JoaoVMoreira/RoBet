package com.robet.robet.Controller;


import com.robet.robet.DTO.ConfrontoIdDTO;
import com.robet.robet.DTO.RodadaAtualDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("confrontos")
public class ConfrontosController {

    @GetMapping("/{rodadaId}")
    public List<ConfrontoIdDTO.Id> getIdConfronto(@PathVariable Integer rodadaId){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36 OPR/114.0.0.0");
        HttpEntity<String> entity = new HttpEntity<>(header);
        String url = "https://www.sofascore.com/api/v1/unique-tournament/325/season/58766/events/round/" + rodadaId;
        try{
            ResponseEntity<ConfrontoIdDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, ConfrontoIdDTO.class);
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
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36 OPR/114.0.0.0");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        try{
            ResponseEntity<RodadaAtualDTO> response = restTemplate.exchange(
                    "https://www.sofascore.com/api/v1/unique-tournament/325/season/58766/team-of-the-week/rounds?limit=100",
                    HttpMethod.GET,
                    entity,
                    RodadaAtualDTO.class);
            return Objects.requireNonNull(response.getBody()).rounds().size() + 1;
        }catch (Exception e){
            System.out.println("\n\n\n");
            System.out.println(e.getMessage());
            System.out.println("Erro ao localizar numero da rodada atual");
            System.out.println("\n\n\n");
            return null;
        }
    }
}
