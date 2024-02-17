package it.test_spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.test_spring.models.dto.AcquistoDto;
import it.test_spring.models.dto.UtenteDto;
import it.test_spring.models.entities.LibroEntity;
import it.test_spring.models.entities.RuoloEntity;
import it.test_spring.models.entities.UtenteEntity;
import it.test_spring.models.repository.UtenteRepository;
import it.test_spring.utils.loggers.UtenteLogger;

@Service
public class UtenteService {

	private static final Long DEFAULT_ID_ROLE = 1L;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private UtenteLogger utenteLogger;

	@Autowired
	private LibroService libroService;

	@Autowired
	private RuoloService ruoloService;

	public List<UtenteEntity> getAllUtenti() {
		List<UtenteEntity> utenti = utenteRepository.findAll();

		if (utenti.size() > 0) {
			utenteLogger.log.info("Utenti:" + utenti);

		} else {
			utenteLogger.log.info("Utenti non trovati");
		}

		return utenti;
	}

	public UtenteEntity getUtente(Long id) {
		return utenteRepository.findById(id).get();
	}

	public UtenteEntity insertUtente(UtenteDto utenteDto) {
		UtenteEntity insertUtente = null;
		UtenteEntity utenteEntity = new UtenteEntity();
		
		utenteEntity.setNomeUtente(utenteDto.getNomeUtente());
		utenteEntity.setCognomeUtente(utenteDto.getCognomeUtente());
		utenteEntity.setCompleannoUtente(utenteDto.getCompleanno());
		utenteEntity.setRuolo(ruoloService.getRuolo(utenteDto.getIdRuolo()));
		utenteEntity.setEmailUtente(utenteDto.getEmailUtente());
		utenteEntity.setPasswordUtente(utenteDto.getPasswordUtente());

		insertUtente = utenteRepository.save(utenteEntity);

		return utenteEntity;
	}

	public UtenteEntity updateUtente(Long id, UtenteDto utenteDto) {
		UtenteEntity utente = getUtente(id);
		UtenteEntity updatedUtente = null;

		if (utente != null) {
			utente.setNomeUtente(utenteDto.getNomeUtente());
			utente.setCognomeUtente(utenteDto.getCognomeUtente());
			utente.setEmailUtente(utenteDto.getEmailUtente());
			utente.setPasswordUtente(utenteDto.getPasswordUtente());
			utente.setCompleannoUtente(utenteDto.getCompleanno());
			utente.setYoungUtente(false);
			utente.setRuolo(ruoloService.getRuolo(DEFAULT_ID_ROLE));

			if (utenteDto.getIdRuolo() != null) {
				RuoloEntity ruolo = ruoloService.getRuolo(utenteDto.getIdRuolo());
				if (ruolo != null) {
					utente.setRuolo(ruolo);
				}
			}
			updatedUtente = utenteRepository.save(utente);
		}
		return updatedUtente;
	}

    public UtenteEntity compraLibri(Long id, AcquistoDto acquistoDto) {
        UtenteEntity utente = getUtente(id);
        if (utente != null) {
            List<LibroEntity> libri = new ArrayList<>();
            for (Long idLibro : acquistoDto.getIdListaLibri()) {
                LibroEntity libro = libroService.getLibro(idLibro);
                if (libro != null) {
                    libroService.scontoLibro(libro);
                    libri.add(libro);
                }
            }
            utente.setLibri(libri);
        }
        return utenteRepository.save(utente);
    }
    
    

	public List<UtenteEntity> getDueUtentiGiovani() {
		return utenteRepository.getDueUtentiGiovani();
	}

	public List<UtenteEntity> setUtentiGiovani(List<UtenteEntity> utenti) {
		for (UtenteEntity utente : utenti) {
			utente.setYoungUtente(true);
			utenteRepository.save(utente);
		}
		return utenti;
	}

	public Set<Long> getLibriPiuAcquistati() {
		List<UtenteEntity> utenti = getAllUtenti();
		Set<Long> idLibroRegalato = new HashSet<>();

		for (UtenteEntity utente : utenti) {
			if (utente.getLibri().size() >= 2) {
				List<LibroEntity> libri = utente.getLibri();
				for (LibroEntity libro : libri) {
					if (libro.getPrezzoLibro() >= 50.00) {
						idLibroRegalato.add(libro.getIdLibro());
					}
				}
			}
		}
		return idLibroRegalato;
	}

	// internet
	public List<Long> getUtentiConMenoLibri() {
		List<Object[]> utentiConMenoLibri = utenteRepository.findUtentiConMenoLibri();
		List<Long> idLista = new ArrayList<>();
		for (Object[] obj : utentiConMenoLibri) {
			Long idUtente = (Long) obj[0];
			idLista.add(idUtente);
		}
		return idLista;
	}

	public void deleteUtente(Long id) {
		utenteRepository.deleteById(id);
	}

}
