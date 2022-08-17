package org.sid.coursservice.model;

import java.util.Date;

import lombok.Data;

@Data
public class Annonce{
	
	private Long id;
	private String description;
	private String fichier;
	private Date dateHeure;
}
