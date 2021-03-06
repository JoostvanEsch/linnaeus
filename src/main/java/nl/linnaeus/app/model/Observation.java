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
	private Long id;
	private Long userId;
	private String photoUrl;
	private String tag;
	private String location;
	private LocalDateTime datetime;
	private double rating;
	
	//Constructors
	public Observation() {}
	
	public Observation(Long id, Long userId, String photoUrl, String tag, String location, LocalDateTime datetime,
			double rating) {
		super();
		this.id = id;
		this.userId = userId;
		this.photoUrl = photoUrl;
		this.tag = tag;
		this.location = location;
		this.datetime = datetime;
		this.rating = rating;
	}

	//Getters en setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
