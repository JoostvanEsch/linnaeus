package nl.linnaeus.app.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nl.linnaeus.app.engines.ImageAnalyzer;
import nl.linnaeus.app.model.AnalyzedImage;
import nl.linnaeus.app.model.Observation;
import nl.linnaeus.app.model.User;
import nl.linnaeus.app.service.AppService;


@RestController
public class Endpoints {
	
	@Autowired
	AppService appService;
	
	/*
	 ENDPOINTS
	 
	 OBSERVATIONS
		GET:		/get-observations
		POST:	/add-observation
		POST:	/analyze-image-from-url
	 
	 USERS
		GET:		/get-users
		POST:	/register-user
		POST:	/login
	 
	 TEST
	 	GET:		/test
	 
	*/
	
	
	//////////////////
	// Observations //
	//////////////////
	
	//get-observation
    @ResponseBody
    @GetMapping("/get-observations")
    public List<Observation> getObservations() {
    		return appService.getObservationsFromDatabase();
    }
	
	//add-observation
	//Observation object met userId en url geinstantieerd
	@PostMapping("/add-observation")
	public void addObservation(@RequestBody Observation observation) {
		LocalDateTime localDateTime = LocalDateTime.now();
		
		observation.setTag("dummyTag");
		observation.setLocation("dummyLocation");
		observation.setDatetime(localDateTime);
		observation.setRating((double) 5);
		
		appService.addObservationToDatabase(observation);
	}
	
	//analyze-image-from-url
	//.jpg afbeelding in imgur link
	@ResponseBody
    @PostMapping("/analyze-image-from-url")
    public String analyzeImageFromUrl(@RequestBody String url){
		System.out.println(url);
		ImageAnalyzer ia = new ImageAnalyzer();
		System.out.println("ImageAnalyzer instantiated");
		AnalyzedImage AnIm = ia.processURL(url);
		System.out.println("AnalyzedImage instantiated");
		System.out.println("Tag determined: " + AnIm.determineTag());
        return AnIm.determineTag();
    }
	
	
	///////////
	// Users //
	///////////
	
	//get-users
    @ResponseBody
    @GetMapping("/get-users")
    public List<User> getUsers() {
    		return appService.getUsersFromDatabase();
    }
	
	//register-user
	//geldig email adres + wachtwoord mag alleen letters en cijfers bevatten
	@PostMapping("/register-user")
	public String postRegistration(@RequestBody User user){
		
		ArrayList<User> userList = new ArrayList<User>();
		userList = appService.getUsersFromDatabase();
		boolean userMailValid;
		boolean userMailAvailable = true;
		boolean passwordValid = true;
		
		//Check geldigheid emailadres
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(user.getMail());
        if (mat.matches()) {
        		userMailValid = true;
        } else {
        		userMailValid = false;
        }
        
		//Check of gebruiker al bestaat
		for (User u : userList) {
			if (user.getMail().equalsIgnoreCase(u.getMail())) {
				userMailAvailable = false;
			}
		}
        
        //Check geldigheid password
        if (user.getPassword().length() < 1) {
        		passwordValid = false;
        } else {
			for (int j = 0; j < user.getPassword().length(); j++) {
				if (!Character.isLetterOrDigit(user.getPassword().charAt(j))) {
					passwordValid = false;
				}
			}
        }
		
		//Gebruiker registreren als voldaan wordt aan voorwaarden
		if (userMailAvailable == true && userMailValid == true && passwordValid == true) {
			user.encryptPassword();
			appService.addUserToDatabase(user);
			return new String("Registratie gelukt");
		} else {
			return new String("Registratie mislukt");
		}
	}
	
	//login
	//geregsitreed email adres + geldig wachtwoord
	@PostMapping("/login")
	public String postLogin(@RequestBody User user){
		
		ArrayList<User> userList = new ArrayList<User>();
		userList = appService.getUsersFromDatabase();
		boolean userExists = false;
		long uid = 0;
		String uPass = "";
		
		for (User u : userList) {
			if (u.getMail().equalsIgnoreCase(user.getMail())) {
				userExists = true;
				uid = u.getId();
				uPass = u.getEncryptedPassword();
			}
		}
		
		if (userExists == false) {
		return new String("Login fail: User does not exist");
		} else {
			if (User.encrypt(user.getPassword()).equals(uPass)) {
				return new String("Login succes: uid="+uid);
			} else {
				return new String("Login fail: Password incorrect");
			}
		}
	}

	
    ///////////////////
    // Test endpoint //
    ///////////////////
	
	//test
	@ResponseBody
    @GetMapping("/test")
    public void getTest(){
		System.out.println("werkt");
    }

}
