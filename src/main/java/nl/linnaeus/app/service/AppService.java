package nl.linnaeus.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.linnaeus.app.model.User;

@Service
@Transactional
public class AppService {
	
    @Autowired
    UserRepository userRepository;
    
	public void addToDatabase(User user) {
		userRepository.save(user);
	}
	
	public ArrayList<User> getUsersFromDatabase() {
		return (ArrayList<User>) userRepository.findAll();
	}

}
