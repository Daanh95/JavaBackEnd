package nl.sportnut.voeding.api;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

import java.util.Optional;
import java.util.Scanner; 

import nl.sportnut.voeding.gebruikers.GebruikerRepository;
import nl.sportnut.voeding.gebruikers.GebruikerService;
import nl.sportnut.voeding.model.Gebruikers;

@RestController
@CrossOrigin(maxAge = 3600)
public class KlantEndpoint {
	private static final Gebruikers String = null;
	@Autowired
	GebruikerService gs;
	
	// Creates a user into the database with all their variables
	// the link to go to the website register/Herman/kano/77/156/true/400/1400
	@GetMapping("/register/{username}/{password}/{weightUser}/{lengthUser}/{sexUser}/{fitnessGoal}/{dietGoal}")
	public Gebruikers createUser(@PathVariable String username, @PathVariable String password, @PathVariable int weightUser, @PathVariable int lengthUser, @PathVariable boolean sexUser, @PathVariable int dietGoal, @PathVariable int fitnessGoal) {
		Gebruikers mijnUser = new Gebruikers();
		mijnUser.setPassword(password);
		mijnUser.setUsername(username);
		mijnUser.setWeightUser(weightUser);
		mijnUser.setLenghtUser(lengthUser);
		mijnUser.setSexUser(sexUser);
		mijnUser.setFitnessGoal(fitnessGoal);
		mijnUser.setDietGoal(dietGoal);
		
		//mijnUser.setId(id);
		//mijnUser.setAgeUser(ageUser);
		
		gs.saveUser(mijnUser);
		
		return mijnUser;
	}
	
	// Finds a specific user by ID
	@GetMapping("/testing/{id}")
	public Optional<Gebruikers> testUser(@PathVariable long id) {
		
		var gebruiker = gs.findUser(id);
	    return gebruiker;
	}
	
	
	// Updates the username within the user
	@GetMapping("/update/{id}/{username}")
	public Optional<Gebruikers> updateUser(@PathVariable Long id, @PathVariable String username) {
		var updating = gs.updateUser(id, username);
		return updating;
	}
	
	// Shows all the users with their variables.
	@GetMapping ("/klant")
	public Iterable<Gebruikers> A () {
		return gs.getAll();
	}
}
