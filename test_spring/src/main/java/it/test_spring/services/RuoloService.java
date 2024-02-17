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
	
	public RuoloEntity insertRuoli(RuoloEntity ruoloEntity) {
		return ruoloRepository.save(ruoloEntity);
	}
	
	public RuoloEntity updateRuoli(Long id, RuoloEntity ruoloEntity) {
		RuoloEntity ruolo = getRuolo(id);
		RuoloEntity updatedRuolo = null;
		
		if (ruolo != null) {
			ruolo.setIdRuolo(ruoloEntity.getIdRuolo());
			ruolo.setNomeRuolo(ruoloEntity.getNomeRuolo());
			
			updatedRuolo = ruoloRepository.save(ruolo);
		}
		return updatedRuolo;
	}
	
	public void deleteRuolo(Long id) {
		ruoloRepository.deleteById(id);
	}
}
