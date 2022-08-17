package org.sid.coursservice.web;

import org.sid.coursservice.entities.Cours;
import org.sid.coursservice.feign.AnnonceItemRestClient;
import org.sid.coursservice.feign.EnseignantRestClient;
import org.sid.coursservice.model.Annonce;
import org.sid.coursservice.model.Enseignant;
import org.sid.coursservice.repository.AnnonceItemRepository;
import org.sid.coursservice.repository.CoursRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursRestController {
	
	private CoursRepository coursRepository;
	private AnnonceItemRepository annonceItemRepository;
	private EnseignantRestClient enseignantRestClient;
	private AnnonceItemRestClient annonceItemRestClient;
	
	
	
	
	public CoursRestController(CoursRepository coursRepository, AnnonceItemRepository annonceItemRepository,
			EnseignantRestClient enseignantRestClient, AnnonceItemRestClient annonceItemRestClient) {
		super();
		this.coursRepository = coursRepository;
		this.annonceItemRepository = annonceItemRepository;
		this.enseignantRestClient = enseignantRestClient;
		this.annonceItemRestClient = annonceItemRestClient;
	}




	@GetMapping(path = "/fullCours/{id}")
	public Cours getCours(@PathVariable(name ="id") Long id) {
		Cours cours = coursRepository.findById(id).get();
		Enseignant enseignant=enseignantRestClient.getEnseignantById(cours.getEnseignantID());
		cours.setEnseignant(enseignant);
		cours.getAnnonceItems().forEach(pi ->{
			Annonce annonce =annonceItemRestClient.getAnnonceById(pi.getAnnonceID());
			pi.setAnnonce(annonce);
			
		});
		return cours;
		
	}

}