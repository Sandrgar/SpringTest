package it.test_spring.models.dto;

import java.time.LocalDate;

public class SignupDto {

	private String nomeUtente;
	private String cognomeUtente;
	private String email;
	private String password;
	private LocalDate compleanno;
	
	public SignupDto() {}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCompleanno() {
		return compleanno;
	}

	public void setCompleanno(LocalDate compleanno) {
		this.compleanno = compleanno;
	}
	
	
}
