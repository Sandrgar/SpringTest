package it.test_spring.models.dto;

import java.time.LocalDate;




public class UtenteDto {

	private String nomeUtente;
	private String cognomeUtente;
	private String emailUtente;
	private String passwordUtente;
	private LocalDate compleanno;
	private boolean isYoung;
	private Long idRuolo;
	
    public UtenteDto() {}

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

	public String getEmailUtente() {
		return emailUtente;
	}

	public void setEmailUtente(String emailUtente) {
		this.emailUtente = emailUtente;
	}

	public String getPasswordUtente() {
		return passwordUtente;
	}

	public void setPasswordUtente(String passwordUtente) {
		this.passwordUtente = passwordUtente;
	}

	public LocalDate getCompleanno() {
		return compleanno;
	}

	public void setCompleanno(LocalDate compleanno) {
		this.compleanno = compleanno;
	}

	public boolean isYoung() {
		return isYoung;
	}

	public void setYoung(boolean isYoung) {
		this.isYoung = isYoung;
	}

	public Long getIdRuolo() {
		return idRuolo;
	}

	public void setIdRuolo(Long idRuolo) {
		this.idRuolo = idRuolo;
	}

    
    
    
    
}
