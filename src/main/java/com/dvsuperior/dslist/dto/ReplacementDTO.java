package com.dvsuperior.dslist.dto;

public class ReplacementDTO {

	//Como foi criado um objeto de origem/destino no corpo(body) do Postman, é necessário criar um DTO para esse objeto.
	private Integer sourceIndex;
	private Integer destinationIndex;
	
	
	public Integer getSourceIndex() {
		return sourceIndex;
	}
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	public Integer getDestinationIndex() {
		return destinationIndex;
	}
	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
	
	
}
