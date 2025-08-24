package com.dvsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.dslist.dto.GameListDTO;
import com.dvsuperior.dslist.entities.GameList;
import com.dvsuperior.dslist.projections.GameMinProjection;
import com.dvsuperior.dslist.repositories.GameListRepository;
import com.dvsuperior.dslist.repositories.GameRepository;


@Service //estou registrando o 'service' como componente no sistema
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository; // O 'gameRepository' é um componente do sistema, e eu preciso injetar uns nos outros para compor o sistemas em varios componentes  
	
	@Autowired
	private GameRepository gameRepository; 
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();// o 'finAll' é um metodo que por padrao vai gerar um consulta no banco de dados para buscar do banco de dados todos os games
		return result.stream().map(x -> new GameListDTO(x)).toList(); //stream- é uma lib do java que permite fazer alteraçoes com sequencia de dados 

	}
	
    //Atualizar a posição dos jogos na lista:
	@Transactional 
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId); // Esse é um método de busca dos jogos na lista
		
		GameMinProjection obj = list.remove(sourceIndex); //É uma função que remove de uma posição. O 'sourceIndex'- objeto que está na posição de origem 
		list.add(destinationIndex, obj); // Essa função vai adicionar o objeto que foi removido na lista novamente, porém, vai adicionar ele na posição 1
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; // 0 '?' significa 'então' em java. E o ':' significa 'caso contrario'
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; 
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i); //Essa é uma lógica para trocar a posição dos jogos na lista e atualizar no banco de dados
		}
		
	}
}
