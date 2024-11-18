package com.robet.robet.Service;

import com.robet.robet.Controller.ConfrontosController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfrontosService {

    @Autowired
    private ConfrontosController controller = new ConfrontosController();


}
