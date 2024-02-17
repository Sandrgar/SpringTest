package it.test_spring.models.dto;

import java.time.LocalDate;


public class LibroDto {


	private String titoloLibro;
	private double prezzoLibro;
	private Long idAutore;
	private int copieVenduteLibro;
	private LocalDate dataPubblicazioneLibro;
	private boolean isBestSeller;

	
	public LibroDto() {}


	public String getTitoloLibro() {
		return titoloLibro;
	}


	public void setTitoloLibro(String titoloLibro) {
		this.titoloLibro = titoloLibro;
	}


	public double getPrezzoLibro() {
		return prezzoLibro;
	}


	public void setPrezzoLibro(double prezzoLibro) {
		this.prezzoLibro = prezzoLibro;
	}


	public Long getIdAutore() {
		return idAutore;
	}


	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}


	public int getCopieVenduteLibro() {
		return copieVenduteLibro;
	}


	public void setCopieVenduteLibro(int copieVenduteLibro) {
		this.copieVenduteLibro = copieVenduteLibro;
	}


	public LocalDate getDataPubblicazioneLibro() {
		return dataPubblicazioneLibro;
	}


	public void setDataPubblicazioneLibro(LocalDate dataPubblicazioneLibro) {
		this.dataPubblicazioneLibro = dataPubblicazioneLibro;
	}


	public boolean isBestSeller() {
		return isBestSeller;
	}


	public void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}

	
	
	
	
	
	
	
}
