/*package com.robet.robet.Controller;

import com.robet.robet.DTO.ConfrontoIdDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ConfrontosControllerTest {

    @MockBean
    private RestTemplate restTemplate; // Usa MockBean para que Spring injete o mock no contexto

    @Autowired
    private ConfrontosController confrontosController;

    @Test
    @DisplayName("Should return a list of Integer when requisiton is ok")
    public void deveRetornarListaDeIds() {
        // URL completa que será mockada
        String url = "https://www.sofascore.com/api/v1/unique-tournament/325/season/58766/events/round/123";

        // Simula uma resposta válida com IDs
        List<ConfrontoIdDTO.Id> idList = List.of(new ConfrontoIdDTO.Id(1), new ConfrontoIdDTO.Id(2));
        ConfrontoIdDTO confrontoIdDTO = new ConfrontoIdDTO(idList);
        ResponseEntity<ConfrontoIdDTO> responseEntity = new ResponseEntity<>(confrontoIdDTO, HttpStatus.OK);

        // Configura o mock para retornar a resposta simulada com a URL exata
        when(restTemplate.getForEntity(url, ConfrontoIdDTO.class)).thenReturn(responseEntity);

        // Executa o método com a `rodadaId` especificada para a URL mockada
        List<Integer> resultado = confrontosController.getIdConfronto(123);

        // Verifica o retorno
        assertEquals(List.of(1, 2), resultado);
    }

    @Test
    @DisplayName("Should Throw a Exception when requisiton failed")
    public void deveLancarExcecaoQuandoFalhaNaRequisicao() {
        // Configura o mock para lançar uma exceção
        when(restTemplate.getForEntity(anyString(), eq(ConfrontoIdDTO.class)))
                .thenThrow(new RuntimeException("Erro na requisição"));

        // Executa o método e verifica se o retorno é nulo ao capturar a exceção
        List<Integer> resultado = confrontosController.getIdConfronto(123);
        assertNull(resultado);
    }
}*/