package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

// Objeto responsavel por fazer consultas ao banco de dados
public interface GameListRepository extends JpaRepository<GameList, Long> {

}
