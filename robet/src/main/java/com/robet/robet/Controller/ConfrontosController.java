package com.robet.robet.Controller;


import com.robet.robet.DTO.ConfrontoIdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Objects;

@RestController
@RequestMapping("confrontos")
public class ConfrontosController {

    @GetMapping("{rodadaId}")
    public Integer getIdConfronto(@PathVariable int rodadaId){
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<ConfrontoIdDTO> response = restTemplate.getForEntity("https://www.sofascore.com/api/v1/unique-tournament/325/season/58766/events/round/{rodadaId}", ConfrontoIdDTO.class);
            return Objects.requireNonNull(response.getBody()).confrontoId();
        }catch (Exception e){
            System.out.println("Erro na requisição do idConfronto");
            return null;
        }
    }
}
