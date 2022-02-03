package nl.sportnut.voeding.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import nl.sportnut.voeding.gebruikers.GebruikerRepository;
import nl.sportnut.voeding.gebruikers.GebruikerService;
import nl.sportnut.voeding.model.Gebruiker;

@RestController
@CrossOrigin(maxAge = 3600)
public class KlantEndpoint {
	private static final Gebruiker String = null;
	@Autowired
	GebruikerService gs; // Gives a shortcut to GebruikersService in order to call the functions in the class.
	
	// The browser sends a body to /create. The body will be caught in @Requestbody and will be made a new Gebruiker.
	@PostMapping("/create")
	public Gebruiker create (@RequestBody Gebruiker gebruiker) {
			
		// The new body will be send towards the KlantEndpoint and will there be saved upon the database.
		return gs.create(gebruiker);
	}
	
	// The browser sends a body that needs to be updated to update /update together with the ID of the Gebruiker that needs to be updated
	// The body will be caught in @Requestbody and will be used to update the existing user with new details.
	@PutMapping("/update/{id}")
	public Gebruiker updateClient(@RequestBody Gebruiker gebruikerDetails, @PathVariable String id){
		
		// To find the KeyValue of th user the id that has been send to the browser has to be made a long. This is used by the repository to save users into the database.
		long newID = Long.parseLong(id);
		
		// In order to update the client the updateClient method in GebruikerService will be called that needs both the updated body and the ID.
		return gs.updateClient(gebruikerDetails, newID);
	}
	
	// Can be called to show all the users and their values within the database.
	@GetMapping ("/klant")
	public Iterable<Gebruiker> A () {
		
		// Calls the getAll function in GebruikerService to show all the users into the browser.
		return gs.getAll();
	}
	
	
	// Finds a specific user by ID
	@GetMapping("/user/{id}")
	public Optional<Gebruiker> testUser(@PathVariable String id) {
		long newID = Long.parseLong(id);
		var gebruiker = gs.findUser(newID);
		return gebruiker;
	}
	
	
}
