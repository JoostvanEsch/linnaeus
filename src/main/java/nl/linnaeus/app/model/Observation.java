package nl.linnaeus.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Observation {
	
	//Fields
	@Id
	@GeneratedValue
	private long id;
	private String photoUrl;
	private String tag;
	private User user;
	private String location;
	private LocalDateTime datetime;
	private double rating;
	
	//Constructors
	
	//Getters en setters
	

}
