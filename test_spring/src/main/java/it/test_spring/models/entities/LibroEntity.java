package it.test_spring.models.entities;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class LibroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro")
	private Long idLibro;

	@Column(name = "titolo", nullable = false, unique = true)
	private String titoloLibro;

	@Column(name = "prezzo")
	private double prezzoLibro;

	@Column(name = "genere")
	private String genereLibro;

	@Column(name = "autore")
	private String autoreLibro;
	
	@Column (name = "data_pubblicazione")
	private LocalDate dataPubblicazioneLibro;
	
	@Column(name ="copie_vendute")
	private int copieVenduteLibro;
	
	@Column(name = "is_bestSeller")
	private boolean isBestSellerBook;

	
	@ManyToOne
	@JoinColumn(name = "id_autore")
	private AutoreEntity autore;
	
	@ManyToMany
	@JoinTable(name = "utente_libro", 
	           joinColumns = @JoinColumn(name = "id_libro"), 
	           inverseJoinColumns = @JoinColumn(name = "id_utente"))
	private List<UtenteEntity> utenti;
	
	public LibroEntity() {}

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

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

	public String getGenereLibro() {
		return genereLibro;
	}

	public void setGenereLibro(String genereLibro) {
		this.genereLibro = genereLibro;
	}

	public String getAutoreLibro() {
		return autoreLibro;
	}

	public void setAutoreLibro(AutoreEntity autore) {
		this.autore = autore;
	}

	public LocalDate getDataPubblicazioneLibro() {
		return dataPubblicazioneLibro;
	}

	public void setDataPubblicazioneLibro(LocalDate dataPubblicazioneLibro) {
		this.dataPubblicazioneLibro = dataPubblicazioneLibro;
	}

	public int getCopieVenduteLibro() {
		return copieVenduteLibro;
	}

	public void setCopieVenduteLibro(int copieVenduteLibro) {
		this.copieVenduteLibro = copieVenduteLibro;
	}

	public boolean isBestSellerBook() {
		return getCopieVenduteLibro() >=2;
	}

	public void setBestSellerBook(boolean isBestSellerBook) {
		this.isBestSellerBook = isBestSellerBook;
	}

	public AutoreEntity getAutore() {
		return autore;
	}

	public void setAutore(AutoreEntity autore) {
		this.autore = autore;
	}

	public List<UtenteEntity> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<UtenteEntity> utenti) {
		this.utenti = utenti;
	}

	
	
	
	
}
