package nl.linnaeus.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	//Fields
    @Id
    @GeneratedValue
    private Long id;
    private String mail;
    private String password;
    
    //Constructors
    public User() {}
    
    public User(Long id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    //Getters en setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
}
