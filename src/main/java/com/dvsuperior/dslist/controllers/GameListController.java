package com.dvsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dslist.dto.GameListDTO;
import com.dvsuperior.dslist.dto.GameMinDTO;
import com.dvsuperior.dslist.dto.ReplacementDTO;
import com.dvsuperior.dslist.services.GameListService;
import com.dvsuperior.dslist.services.GameService;

//O 'controller' é a porta de entrada do banck-end, ele vai disponibilizar a API
@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired //injetei um 'Service" do controller
	private GameListService gameListService;
	 
	@Autowired
	private GameService gameService;
	
	@GetMapping //O 'get' serve pra buscar
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games") //O 'get' serve pra buscar
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	// Atualizando a posição dos jogos na lista:
	@PostMapping(value = "/{listId}/replacement") //O 'get' serve pra buscar
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
