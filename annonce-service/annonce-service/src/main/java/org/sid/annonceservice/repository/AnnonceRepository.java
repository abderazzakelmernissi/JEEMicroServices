package org.sid.annonceservice.repository;

import org.sid.annonceservice.entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
