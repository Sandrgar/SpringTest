package it.test_spring.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "utente")
public class UtenteEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utente")
	private Long idUtente;

	@Column(name = "nome", nullable = false)
	private String nomeUtente;

	@Column(name = "cognome", nullable = false)
	private String cognomeUtente;

	@Column(name = "email", nullable = false, unique = true)
	private String emailUtente;

	@Column(name = "password", nullable = false)
	private String passwordUtente;

	@Column(name = "compleanno")
	private LocalDate compleannoUtente;

	@Column(name = "is_young")
	private boolean isYoungUtente;

	@ManyToOne
	@JoinColumn(name = "id_ruolo")
	private RuoloEntity ruolo;

	@ManyToMany
    @JoinTable(
            name = "utente_libro",
            joinColumns = @JoinColumn(name = "id_utente"),
            inverseJoinColumns = @JoinColumn(name = "id_libro"))
	@JsonManagedReference
    private List<LibroEntity> libri;
	
	public UtenteEntity() {}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

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

	public LocalDate getCompleannoUtente() {
		return compleannoUtente;
	}

	public void setCompleannoUtente(LocalDate compleannoUtente) {
		this.compleannoUtente = compleannoUtente;
	}

	public boolean isYoungUtente() {
		return isYoungUtente;
	}

	public void setYoungUtente(boolean isYoungUtente) {
		this.isYoungUtente = isYoungUtente;
	}

	public RuoloEntity getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloEntity ruole) {
		this.ruolo = ruole;
	}

	public List<LibroEntity> getLibri() {
		return libri;
	}

	public void setLibri(List<LibroEntity> libri) {
		this.libri = libri;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if (getRuolo() != null) {
			authorities.add(new SimpleGrantedAuthority(getRuolo().getNomeRuolo()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return getPasswordUtente();
	}

	@Override
	public String getUsername() {
		return getEmailUtente();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
