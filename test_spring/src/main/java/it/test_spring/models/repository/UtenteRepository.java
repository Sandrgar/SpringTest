package it.test_spring.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.test_spring.models.entities.UtenteEntity;


@Repository
public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {
	UtenteEntity findUtenteByEmailUtente(String email);
	
    @Query("SELECT u FROM UtenteEntity u ORDER BY u.compleannoUtente DESC LIMIT 2")
    List<UtenteEntity> getDueUtentiGiovani();
    
    @Query("SELECT u.idUtente, COUNT(b.idLibro) AS numeroLibri " +
            "FROM UtenteEntity u " +
            "LEFT JOIN u.libri b " +
            "GROUP BY u.idUtente " +
            "ORDER BY numeroLibri ASC LIMIT 3")
    
    List<Object[]> findUtentiConMenoLibri();
}
