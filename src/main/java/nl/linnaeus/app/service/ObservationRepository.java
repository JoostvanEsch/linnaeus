package nl.linnaeus.app.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import nl.linnaeus.app.model.Observation;

@Component
public interface ObservationRepository extends CrudRepository<Observation, Long> {

}
