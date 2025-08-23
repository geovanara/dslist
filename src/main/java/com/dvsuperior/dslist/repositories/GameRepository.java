package com.dvsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dvsuperior.dslist.entities.Game;
import com.dvsuperior.dslist.projections.GameMinProjection;

//Isso é um componente que vai fazer consulta com o banco de dados, inserir, alterar, detelar e etc
public interface GameRepository extends JpaRepository<Game, Long> {

	
	// Foi colocado o 'nativeQuery = true' porque é uma condição que precisa ser colocada na annotation '@Query'
	// pra funcionar a consulta SQL, por utilizar essa condição, o resultado da consulta precisar ser uma 'interface' que nesse caso, 
	// é o 'List<GameMinProjection>'
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS "year", tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);// O parâmetro que eu passar para o ':listId' vai entrar na busca do banco de dados pela lista

	
	
}
 