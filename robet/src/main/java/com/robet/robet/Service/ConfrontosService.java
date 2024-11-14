package com.robet.robet.Service;

import com.robet.robet.Controller.ConfrontosController;
import com.robet.robet.Controller.EscanteiosController;
import com.robet.robet.DTO.ConfrontoIdDTO;
import com.robet.robet.DTO.StatsEscanteiosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfrontosService {

    @Autowired
    private ConfrontosController controller = new ConfrontosController();

}
