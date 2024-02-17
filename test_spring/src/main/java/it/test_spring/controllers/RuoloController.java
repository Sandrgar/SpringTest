package it.test_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.test_spring.models.entities.RuoloEntity;
import it.test_spring.services.RuoloService;

@RestController
@RequestMapping("/ruoli")
public class RuoloController {
	
	@Autowired
	private RuoloService ruoloService;
	
	@GetMapping
	public List<RuoloEntity> getAllRuoli(){
		return ruoloService.getAllRuoli();
	}
	

}
