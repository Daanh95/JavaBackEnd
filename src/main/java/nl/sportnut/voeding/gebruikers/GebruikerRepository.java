package nl.sportnut.voeding.gebruikers;
import org.springframework.data.repository.CrudRepository ;
import org.springframework.stereotype.Component;

import nl.sportnut.voeding.model.*;

@Component
public interface GebruikerRepository extends CrudRepository  <Gebruikers, Long> {

}
	