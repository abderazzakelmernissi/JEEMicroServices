package org.sid.coursservice;

import java.util.Date;

import org.sid.coursservice.entities.AnnonceItem;
import org.sid.coursservice.entities.Cours;
import org.sid.coursservice.feign.AnnonceItemRestClient;
import org.sid.coursservice.feign.EnseignantRestClient;
import org.sid.coursservice.model.Annonce;
import org.sid.coursservice.model.Enseignant;
import org.sid.coursservice.repository.AnnonceItemRepository;
import org.sid.coursservice.repository.CoursRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

@SpringBootApplication
@EnableFeignClients
public class CoursServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CoursRepository coursRepository,
							AnnonceItemRepository annonceItemRepository,
							EnseignantRestClient enseignantRestClient,
							AnnonceItemRestClient annonceItemRestClient) {
		
		return Args ->{
		
			Enseignant enseignant= enseignantRestClient.getEnseignantById(1L);
			Cours cours = coursRepository.save(new Cours(null,"IntitileTest",new Date(),null,enseignant.getId(),null));
			
			PagedModel<Annonce> annoncePagedModel=annonceItemRestClient.pageAnnonce(0,20);
			annoncePagedModel.forEach(p -> {
				AnnonceItem annonceItem = new AnnonceItem();
				annonceItem.setDescription(p.getDescription());
				annonceItem.setFichier(p.getFichier());
				annonceItem.setDateHeure(p.getDateHeure());
				annonceItem.setAnnonceID(p.getId());
				annonceItem.setCours(cours);
				annonceItemRepository.save(annonceItem);
			});
			
			/*
			 * System.out.println("*******Cours*Cours*Cours*Cours****************");
			 * System.out.println(enseignant.getId());
			 * System.out.println(enseignant.getName());
			 * System.out.println(enseignant.getAdrEmail());
			 * System.out.println(enseignant.getPrenom());
			 */
			
		};
	}

}