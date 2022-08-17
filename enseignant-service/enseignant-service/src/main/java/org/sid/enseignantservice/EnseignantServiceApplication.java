package org.sid.enseignantservice;

import org.sid.enseignantservice.entities.Enseignant;
import org.sid.enseignantservice.repository.EnseignantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class EnseignantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnseignantServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(EnseignantRepository enseignantRepository, RepositoryRestConfiguration restConfiguration) {
		
		restConfiguration.exposeIdsFor(Enseignant.class);
		return Args -> {
			enseignantRepository.save(new Enseignant(null,"NomE1","PrenE1","E1@mail.com"));
			enseignantRepository.save(new Enseignant(null,"NomE2","PrenE2","E2@mail.com"));
			enseignantRepository.save(new Enseignant(null,"NomE3","PrenE3","E3@mail.com"));
			enseignantRepository.findAll().forEach(c ->{
				System.out.println(c.toString());
			});
			
		};
	}

}
