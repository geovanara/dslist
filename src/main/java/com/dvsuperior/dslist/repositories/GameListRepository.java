package com.dvsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dvsuperior.dslist.entities.GameList;

//Isso é um componente que vai fazer consulta com o banco de dados, inserir, alterar, detelar e etc
public interface GameListRepository extends JpaRepository<GameList, Long>{

	
	//Atualizar posição da lista:
	
	//Toda vez que é uma função que não é o 'SELECT', eu preciso colocar o '@Modifying'!!
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition); // Essa função vai atualizar a posição dos jogos
}
 