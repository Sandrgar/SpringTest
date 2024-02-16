package it.test_spring.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.test_spring.models.entities.LibroEntity;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long>{
 
	   @Query("SELECT b FROM LibroEntity b " +
	            "JOIN b.autore a " +
	            "ORDER BY a.cognomeAutore, b.prezzoLibro DESC")
	    List<LibroEntity> getLibriAutorePrezzo();
}
