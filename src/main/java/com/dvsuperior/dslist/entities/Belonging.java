package com.dvsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	@EmbeddedId
	//Essa vai ser a classe responsável popr mover a posição dos filmes no site
	private BelongingPK id = new BelongingPK();
	
	private Integer position;
	
	public Belonging() {
		
	}

	public Belonging(Game game, GameList list, Integer position) {  
		//A referência de 'Game'(id.setGame(Game) e id.setList(List)), eu vou jogar pra dentro da classe 'Belonging' 
		//porque o objeto do Belonging' tem que ter a referência dos atributos: 'Game' e 'GameList'
		id.setGame(game); 
		id.setList(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
