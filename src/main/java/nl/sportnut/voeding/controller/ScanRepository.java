package nl.sportnut.voeding.controller;
import org.springframework.data.repository.CrudRepository ;
import org.springframework.stereotype.Component;

import nl.sportnut.voeding.model.*;

@Component
public interface ScanRepository extends CrudRepository  <Scan, Long> {
	
}
