package nl.linnaeus.app.rest;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

=======
>>>>>>> 1a27f7c7083a9fadba709d280860a559dff53d4f
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import nl.linnaeus.app.engines.ImageAnalyzer;
import nl.linnaeus.app.model.AnalyzedImage;
import nl.linnaeus.app.model.User;
=======
import nl.linnaeus.app.model.AnalyzedImage;
import nl.linnaeus.app.model.ImageAnalyzer;
>>>>>>> 1a27f7c7083a9fadba709d280860a559dff53d4f
import nl.linnaeus.app.service.AppService;


@RestController
public class Endpoints {
	
	@Autowired
	AppService appService;
	
<<<<<<< HEAD
	////////////////////////////
	// Analyze image from URL //
	////////////////////////////
	
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
		boolean userMailTaken = false;
		boolean userMailValid;
		boolean passwordValid = true;
		
		userList = appService.getUsersFromDatabase();
		
		//Check of user.mail een geldig emailadres is, en check of password alleen letters en cijfers bevat
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(user.getMail());
        if (mat.matches()) {
        		userMailValid = true;
        } else {
        		userMailValid = false;
        }
		for (int j = 0; j < user.getPassword().length(); j++) {
			if (!Character.isLetterOrDigit(user.getPassword().charAt(j))) {
				passwordValid = false;
			}
		}
		
		//Check of gebruiker al bestaat
		for (User u : userList) {
			if (u.getMail().equalsIgnoreCase(u.getMail())) userMailTaken = true;
		}
		
		//Gebruiker registreren als voldaan wordt aan voorwaarden
		if (userMailTaken == false && userMailValid == true && passwordValid == true) {
			appService.addToDatabase(user);
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
				uPass = u.getPassword();
			}
		}
		
		if (userExists == false) {
		return new String("Login fail: User does not exist");
		} else {
			if (user.getPassword().equals(uPass)) {
				return new String("Login succes: uid="+uid);
			} else {
				return new String("Login fail: Password incorrect");
			}
		}
	}

	
    ///////////////////
    // Test endpoint //
    ///////////////////
	
	//TODO
=======
	@ResponseBody
    @PostMapping("/analyzeimagefromurl")
    public String analyzeImageFromUrl(@RequestBody String url){
		ImageAnalyzer ia = new ImageAnalyzer();
		AnalyzedImage AnIm = ia.processURL(url);
        return AnIm.determineTag();
    }
	
	@ResponseBody
    @GetMapping("/test")
    public void analyzeImageFrorl(){
		System.out.println("werkt");

    }
>>>>>>> 1a27f7c7083a9fadba709d280860a559dff53d4f

}
