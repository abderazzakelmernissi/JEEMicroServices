package org.sid.coursservice.feign;

import org.sid.coursservice.model.Annonce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ANNONCE-SERVICE")
public interface AnnonceItemRestClient {
	
	@GetMapping(path = "/annonces")
	PagedModel<Annonce> pageAnnonce(@RequestParam(name = "page") int page, @RequestParam(name= "size") int size);

	@GetMapping(path = "/annonces/{id}")
	Annonce getAnnonceById(@PathVariable Long id);
}