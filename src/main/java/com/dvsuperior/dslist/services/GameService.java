package com.dvsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dslist.dto.GameDTO;
import com.dvsuperior.dslist.dto.GameMinDTO;
import com.dvsuperior.dslist.entities.Game;
import com.dvsuperior.dslist.projections.GameMinProjection;
import com.dvsuperior.dslist.repositories.GameRepository;


@Service //estou registrando o 'service' como componente no sistema
public class GameService {

	@Autowired
	private GameRepository gameRepository; // O 'gameRepository' é um componente do sistema, e eu preciso injetar uns nos outros para compor o sistemas em varios componentes  
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get(); //Busquei do banco de dados o 'Game'
		return new GameDTO(result); //e converti em DTO
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();// o 'finAll' é um metodo que por padrao vai gerar um consulta no banco de dados para buscar do banco de dados todos os games
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //stream- é uma lib do java que permite fazer alteraçoes com sequencia de dados 

	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){ //Vou receber o id da lista e retornar os games dessa lista
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList(); //O compilador identificou que tem um construtor que recebe: 'GameMinProjection'

	}
}
