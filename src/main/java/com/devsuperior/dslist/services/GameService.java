package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Componente responsável por implementar lógica/regras de negócio

@Service
public class GameService { // O serviço devolve um DTO

    @Autowired
    private GameRepository gameRepository; // Injetando uma isntância do GameRepository
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll(); // Busca todos os games do BD e coloca numa lista
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // Transforma uma lista de Games em uma de GameDTO
        return dto;
    }
}
