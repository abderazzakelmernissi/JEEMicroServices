package org.sid.annonceservice;

import java.util.Date;
import org.sid.annonceservice.entities.Annonce;
import org.sid.annonceservice.repository.AnnonceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AnnonceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnonceServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(AnnonceRepository annonceRepository ,RepositoryRestConfiguration restConfiguration) {
		restConfiguration.exposeIdsFor(Annonce.class);
		return Args -> {
			annonceRepository.save(new Annonce(null, "Desc1", "Fichier1", new Date()));
			annonceRepository.save(new Annonce(null, "Desc2", "Fichier2", new Date()));
			annonceRepository.save(new Annonce(null, "Desc2", "Fichier3", new Date()));
			annonceRepository.save(new Annonce(null, "Desc4", "Fichier4", new Date()));
			annonceRepository.findAll().forEach(c ->{
				System.out.println(c.toString());
			});
			
			
		};
		
	}

}
