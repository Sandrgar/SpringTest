package it.test_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.test_spring.models.dto.AutoreDto;
import it.test_spring.models.entities.AutoreEntity;
import it.test_spring.models.repository.AutoreRepository;


@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	public List<AutoreEntity> getAllAutori() {
		return autoreRepository.findAll();
	}
	
	public AutoreEntity getAutore(Long id) {
		return autoreRepository.findById(id).get();
	}
	
	public AutoreEntity insertAutore(AutoreDto autoreDto) {
		AutoreEntity author = new AutoreEntity();
		if (autoreDto != null) {
			author.setNomeAutore(autoreDto.getNomeAutore());
			author.setCognomeAutore(autoreDto.getCognomeAutore());
		}
		return autoreRepository.save(author);
	}
	
	public AutoreEntity updateAutore(Long id, AutoreDto autoreDto) {
		AutoreEntity author = getAutore(id);
		AutoreEntity updatedAuthor = null;
		
		if (author != null) {
			author.setNomeAutore(autoreDto.getNomeAutore());
			author.setCognomeAutore(autoreDto.getCognomeAutore());
			
			updatedAuthor = autoreRepository.save(author);
		}
		return updatedAuthor;
	}
	
	public void deleteAutore(Long id) {
		autoreRepository.deleteById(id);
	}
}
