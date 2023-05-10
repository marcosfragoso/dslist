package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Componente responsável por implementar lógica/regras de negócio

@Service
public class GameListService { // O serviço devolve um DTO

    @Autowired
    private GameListRepository gameListRepository; // Injetando uma isntância do GameRepository

    @Transactional
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll(); // Busca todos os games do BD e coloca numa lista
        return result.stream().map(x -> new GameListDTO(x)).toList();

    }
}
