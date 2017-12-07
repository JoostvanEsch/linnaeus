package nl.linnaeus.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class User {
	
	//Static field, initializer en method voor md5 encryptie
    private static MessageDigest digester;
    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static String encrypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }
	
	//Fields
    @Id
    @GeneratedValue
    private Long id;
    private String mail;
    private String password;
    private String encryptedPassword;
    
    //Constructors
    public User() {}
    
    public User(Long id, String mail, String password, String encryptedPassword) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
    }
    
    //Encrypt password
    public void encryptPassword() {
    		System.out.println(encrypt(this.password));
    		setEncryptedPassword(encrypt(this.password));
    		this.password = "encrypted";
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
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
}
