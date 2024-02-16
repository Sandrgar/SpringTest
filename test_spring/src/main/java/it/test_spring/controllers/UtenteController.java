package it.test_spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.test_spring.models.dto.AcquistoDto;
import it.test_spring.models.dto.UtenteDto;
import it.test_spring.models.entities.UtenteEntity;
import it.test_spring.services.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping
	public List<UtenteEntity> getAllUtenti() {
		return utenteService.getAllUtenti();
	}

	@GetMapping("/{id}")
	public UtenteEntity getUtente(@PathVariable Long id) {
		return utenteService.getUtente(id);
	}

	@PutMapping("/{id}")
	public UtenteEntity updateUtente(@PathVariable Long id, @RequestBody UtenteDto utenteDto) {
		return utenteService.updateUtente(id, utenteDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUtente(@PathVariable Long id) {
		utenteService.deleteUtente(id);
	}
	
	@PostMapping("/{id")
	public UtenteEntity LibriComprati (@PathVariable Long id, @RequestBody AcquistoDto acquistoDto) {
		return utenteService.libriComprati(id, acquistoDto);
	}
	
	@GetMapping("/controlloGiovani")
	public List<UtenteEntity> controlloGiovani(){
		List<UtenteEntity> utenti = utenteService.getDueUtentiGiovani();
		String startWithConsonantRegex = "(?i)[^aeiou].*";
		
		for(UtenteEntity utente: utenti) {
			if (utente.getNomeUtente().matches(startWithConsonantRegex)) {
				return utenteService.setUtentiGiovani(utenti);
			}
		}
		return utenti;
	}
	
	@GetMapping("/libri-regalati")
	public void libriRegalati() {
		Set<Long> idSetLibri = utenteService.getLibriPiuAcquistati();
		List<Long> idUtenti = utenteService.getUtentiConMenoLibri();
		List<Long> idLibri = new ArrayList<>(idSetLibri);
		
		AcquistoDto a = new AcquistoDto();
		a.setIdListaLibri(idLibri);
		
		for(Long id : idUtenti) {
			utenteService.libriComprati(id, a);
		}
			}
	
	
}