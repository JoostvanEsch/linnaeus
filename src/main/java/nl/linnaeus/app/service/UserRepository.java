package nl.linnaeus.app.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.linnaeus.app.model.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

}
