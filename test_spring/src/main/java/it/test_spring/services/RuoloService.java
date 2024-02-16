package it.test_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.test_spring.models.entities.RuoloEntity;
import it.test_spring.models.repository.RuoloRepository;

@Service
public class RuoloService {
	@Autowired
	private RuoloRepository ruoloRepository;
	
	public List<RuoloEntity> getAllRuoli() {
		return ruoloRepository.findAll();
	}
	
	public RuoloEntity getRuolo(Long id) {
		return ruoloRepository.findById(id).get();
	}
	
	public RuoloEntity insertRuoli(RuoloEntity roleEntity) {
		return ruoloRepository.save(roleEntity);
	}
	
	public RuoloEntity updateRuoli(Long id, RuoloEntity roleEntity) {
		RuoloEntity ruolo = getRuolo(id);
		RuoloEntity updatedRuolo = null;
		
		if (ruolo != null) {
			ruolo.setIdRuolo(roleEntity.getIdRuolo());
			ruolo.setNomeRuolo(roleEntity.getNomeRuolo());
			
			updatedRuolo = ruoloRepository.save(ruolo);
		}
		return updatedRuolo;
	}
	
	public void deleteRuolo(Long id) {
		ruoloRepository.deleteById(id);
	}
}
