package it.test_spring.models.dto;

import java.util.List;

public class AcquistoDto {

	
	private List<Long> idListaLibri;
	
	public AcquistoDto() {}

	public List<Long> getIdListaLibri() {
		return idListaLibri;
	}

	public void setIdListaLibri(List<Long> idListaLibri) {
		this.idListaLibri = idListaLibri;
	}
	
	
	
}
