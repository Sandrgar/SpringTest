package it.test_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.test_spring.models.dto.AutoreDto;
import it.test_spring.models.entities.AutoreEntity;
import it.test_spring.services.AutoreService;

@RestController
@RequestMapping("/autori")
public class AutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping
	public List<AutoreEntity> getAllAutori() {
		return autoreService.getAllAutori();
	}
	
	@GetMapping("/{id}")
	public AutoreEntity getAutore(@PathVariable Long id) {
		return autoreService.getAutore(id);
	}
	
	@PostMapping
	public AutoreEntity insertAutore(@RequestBody AutoreDto autoreDto) {
		return autoreService.insertAutore(autoreDto);
	}
	
	@PutMapping("/{id}")
	public AutoreEntity updateAutore(@PathVariable Long id, @RequestBody AutoreDto authorDto) {
		return autoreService.updateAutore(id, authorDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAutore(@PathVariable Long id) {
		autoreService.deleteAutore(id);
	}
}
