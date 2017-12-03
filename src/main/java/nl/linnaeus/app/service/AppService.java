package nl.linnaeus.app.service;

<<<<<<< HEAD
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.linnaeus.app.model.User;

=======
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

>>>>>>> 1a27f7c7083a9fadba709d280860a559dff53d4f

@Service
@Transactional
public class AppService {
	
<<<<<<< HEAD
    @Autowired
    UserRepository userRepository;
    
	public void addToDatabase(User user) {
		userRepository.save(user);
	}
	
	public ArrayList<User> getUsersFromDatabase() {
		return (ArrayList<User>) userRepository.findAll();
	}
	
=======
>>>>>>> 1a27f7c7083a9fadba709d280860a559dff53d4f

}
