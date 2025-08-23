package com.dvsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // é uma 'annotation' que eu faço um encapsulamento de dois atributos em uma classe só
public class BelongingPK {

	//Por conta que o 'id' do 'Repository' não pode ser mais de um atributo, é necessario apenas um unico atributo,
	//foi necessário ter criado essa classe auxiliar para representar uma chave múltipla, com mais de um atributo. 
	
	@ManyToOne //é uma 'annotation' que significa 'muitos para um'
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne //é uma 'annotation' que significa 'muitos para um'
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	//Por ser uma chave primária múltipla, eu preciso comparar os dois, por isso foi criado um hashcode e equals para os dois atributos
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
	
	
}
