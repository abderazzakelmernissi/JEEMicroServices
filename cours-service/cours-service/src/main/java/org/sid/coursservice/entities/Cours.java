package org.sid.coursservice.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.sid.coursservice.model.Enseignant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Cours {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String intitulString;
	private Date dateheure;
	
	@OneToMany(mappedBy = "cours")
	private Collection<AnnonceItem> annonceItems;
	private long EnseignantID;
	@Transient
	private Enseignant enseignant;

}
