package org.sid.coursservice.repository;

import java.util.Collection;

import org.sid.coursservice.entities.AnnonceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AnnonceItemRepository extends JpaRepository<AnnonceItem, Long>{

	public Collection<AnnonceItem> findByCoursId(Long id);
}
