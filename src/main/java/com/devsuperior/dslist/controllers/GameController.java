package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController { // Porta de entrada do back-end (O que disponibiliza/implementa a API)
    @Autowired
    private GameService gameService; // Injetando um Service no Controller

    @GetMapping(value = "/{id}") // Verbo HTTP (endpoint para buscar)
    public GameDTO findById(@PathVariable Long id) {  // Garantir que o id case com o id da requisicao
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping // Verbo HTTP (endpoint para buscar)
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
