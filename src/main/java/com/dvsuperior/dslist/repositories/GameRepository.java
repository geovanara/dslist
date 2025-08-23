package com.dvsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvsuperior.dslist.entities.Game;

//Isso é um componente que vai fazer consulta com o banco de dados, inserir, alterar, detelar e etc
public interface GameRepository extends JpaRepository<Game, Long>{

	
}
 