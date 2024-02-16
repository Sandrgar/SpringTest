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

import it.test_spring.models.dto.LibroDto;
import it.test_spring.models.entities.LibroEntity;
import it.test_spring.services.LibroService;

@RestController
@RequestMapping("/libri")
public class LibroController {
	
	@Autowired
    private LibroService libroService;

	@GetMapping
	public List<LibroEntity> getAllLibri(){
		return libroService.getAllLibri();
	}
	
	@GetMapping("/{id}")
	public LibroEntity getLibro(@PathVariable Long id) {
		return libroService.getLibro(id);
	}
	
	@PostMapping
	public LibroEntity insertLibro(@RequestBody LibroDto libroDto) {
		return libroService.insertLibro(libroDto);
		
	}
	
	/*@PutMapping("/{id}")
	public LibroEntity updateLibro(@PathVariable Long id, @RequestBody LibroDto libroDto) {
		return libroService.updateLibro(id,libroDto);	
	}*/
	
	@DeleteMapping("/{id}")
	public void deleteLibro(@PathVariable Long id) {
		libroService.deleteLibro(id);
	}
	
	@GetMapping("/AutorePrezzo")
	public List<LibroEntity> getLibriAutorePrezzo(){
		return libroService.getLibriAutorePrezzo();
	}
}
