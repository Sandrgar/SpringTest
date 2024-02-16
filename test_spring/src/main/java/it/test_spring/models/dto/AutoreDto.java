package it.test_spring.models.dto;

public class AutoreDto {
	
	private String nomeAutore;
	private String cognomeAutore;
	
	public AutoreDto() {}

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getCognomeAutore() {
		return cognomeAutore;
	}

	public void setCognomeAutore(String cognomeAutore) {
		this.cognomeAutore = cognomeAutore;
	}

	
}
