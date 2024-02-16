package it.test_spring.utils.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import it.test_spring.models.entities.UtenteEntity;



@Component
public class UtenteLogger {
	public final Logger log = LogManager.getLogger(UtenteEntity.class);

}
