package com.dvsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.dvsuperior.dslist.entities.Game;

//Pra não gerar um loop na API, é necessário utilizar o DTO
//então, o código está padronizado pra sempre retornar DTO e também para evitar 
//problema de representação cíclica de objetos (loop infinito)
public class GameDTO {

	private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;
    
    public GameDTO() {
    	
    }
    
    public GameDTO(Game entity) {
    	BeanUtils.copyProperties(entity, this); //O 'BeanUtils' copia os dados da entidade, e quando eu utilizo o 'BeanUtils', eu preciso criar um get e set para todos os atributos da classe. 
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
    
    
    
}
