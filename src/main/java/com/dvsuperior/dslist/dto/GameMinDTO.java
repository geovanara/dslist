package com.dvsuperior.dslist.dto;

import com.dvsuperior.dslist.entities.Game;

public class GameMinDTO {

	//Como eu só queria puxar do banco os cinco campos, eu criei a classe 'GameMinDTO', que faz isso
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;
    
    public GameMinDTO() {
    	
    }

	public GameMinDTO(Game entity) {
		id = entity.getId(); //não precisa do 'this' pq nao tem mais ambiguidade
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	//So precisa de 'get' no DTO
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
    
    
}
