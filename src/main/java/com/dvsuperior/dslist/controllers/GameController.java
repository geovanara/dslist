package com.dvsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dslist.dto.GameDTO;
import com.dvsuperior.dslist.dto.GameMinDTO;
import com.dvsuperior.dslist.services.GameService;

//O 'controller' é a porta de entrada do banck-end, ele vai disponibilizar a API
@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired //injetei um 'Service" do controller
	private GameService gameService;

	@GetMapping(value = "/{id}") //O 'get' serve pra buscar
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	@GetMapping //O 'get' serve pra buscar
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
}
