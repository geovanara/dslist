package com.dvsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.dslist.dto.GameListDTO;
import com.dvsuperior.dslist.services.GameListService;

//O 'controller' é a porta de entrada do banck-end, ele vai disponibilizar a API
@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired //injetei um 'Service" do controller
	private GameListService gameListService;

	
	@GetMapping //O 'get' serve pra buscar
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
}
