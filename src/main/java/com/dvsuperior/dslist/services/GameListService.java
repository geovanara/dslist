package com.dvsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dslist.dto.GameListDTO;
import com.dvsuperior.dslist.entities.GameList;
import com.dvsuperior.dslist.repositories.GameListRepository;


@Service //estou registrando o 'service' como componente no sistema
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository; // O 'gameRepository' é um componente do sistema, e eu preciso injetar uns nos outros para compor o sistemas em varios componentes  
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();// o 'finAll' é um metodo que por padrao vai gerar um consulta no banco de dados para buscar do banco de dados todos os games
		return result.stream().map(x -> new GameListDTO(x)).toList(); //stream- é uma lib do java que permite fazer alteraçoes com sequencia de dados 

	}
}
