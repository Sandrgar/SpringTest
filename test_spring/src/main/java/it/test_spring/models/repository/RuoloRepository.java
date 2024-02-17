package it.test_spring.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.test_spring.models.entities.RuoloEntity;


@Repository
public interface RuoloRepository extends JpaRepository<RuoloEntity, Long>{

}
