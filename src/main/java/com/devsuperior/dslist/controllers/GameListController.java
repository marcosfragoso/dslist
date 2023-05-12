package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController { // Porta de entrada do back-end (O que disponibiliza/implementa a API)
    @Autowired
    private GameListService gameListService; // Injetando um Service no Controller
    @Autowired
    private GameService gameService;

    @GetMapping // Verbo HTTP (endpoint para buscar)
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games") // Verbo HTTP (endpoint para buscar)
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement") // Verbo HTTP (endpoint para alterar)
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) { // Pega o corpo do postman
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
