package org.sid.coursservice.feign;

import org.sid.coursservice.model.Enseignant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ENSEIGNANT-SERVICE")
public interface EnseignantRestClient {
	@GetMapping(path="/enseignants/{id}")
	public Enseignant getEnseignantById(@PathVariable(name = "id")Long id);

}