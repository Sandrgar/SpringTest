package it.test_spring.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.test_spring.models.entities.AutoreEntity;

@Repository
public interface AutoreRepository extends JpaRepository<AutoreEntity, Long>{

}
