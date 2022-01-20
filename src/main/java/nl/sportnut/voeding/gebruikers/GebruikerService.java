package nl.sportnut.voeding.gebruikers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import nl.sportnut.voeding.gebruikers.GebruikerRepository;
import nl.sportnut.voeding.model.Gebruikers;
import nl.sportnut.voeding.model.Scan;

@Service
public class GebruikerService {
	@Autowired
	GebruikerRepository sr;
	Gebruikers gb;
	private long id;
	private String username;
	private String password;
	private int dietGoal; 
	private int weightUser;
	private int lenghtUser;
	private LocalDate ageUser;
	private boolean sexUser;
	private int fitnessGoal;
	
	// Save all the data in one String to the SQL database
	public void saveUser(Gebruikers mijnUser) {
		sr.save(mijnUser);
	}
	
	// Find user in the SQL database
	public Optional<Gebruikers> findUser(Long identification) {		
		var result = sr.findById(identification);
		return result;
	}
	
	public Optional<Gebruikers> updateUser(Long identification, String username) {		
		Gebruikers updating = sr.findById(identification).get();
		updating.setUsername(username);
		sr.save(updating);
		var result = sr.findById(identification);
		return result;
	}
	
	// Saves an username for the user.
	public void createUserName (String username) {
		Gebruikers name = new Gebruikers();
		name.setUsername(username);
		sr.save(name);
	}
	
	// Saves a password for the user.
	public void createPassword (String password) {
		Gebruikers pass = new Gebruikers();
		pass.setPassword(password);
		sr.save(pass);
	}
	
	// Saves a diet goal for the user.
	public void createDietGoal(int dietGoal) {
		Gebruikers diet = new Gebruikers();
		diet.setDietGoal(dietGoal);
		sr.save(diet);
	}
	
	// Saves a weight for the user.
	public void createWeightUser(int weightUser) {
		Gebruikers weightU = new Gebruikers();
		weightU.setDietGoal(weightUser);
		sr.save(weightU);
	}
	
	// Saves a length for the user.
	public void createLenghtUser(int lenghtUser) {
		Gebruikers lenghtU = new Gebruikers();
		lenghtU.setDietGoal(lenghtUser);
		sr.save(lenghtU);
	}
	
	// Saves an age for the user.
	public void createAgeUser(int ageUser) {
		Gebruikers age = new Gebruikers();
		age.setDietGoal(ageUser);
		sr.save(age);
	}
	
	// Saves a sex for the user.
	public void createSexUser(int sexUser) {
		Gebruikers sex = new Gebruikers();
		sex.setDietGoal(sexUser);
		sr.save(sex);
	}
	
	// Saves a fitness goal for the user.
	public void createFitnessGoal(int fitnessGoal) {
		Gebruikers fitness = new Gebruikers();
		fitness.setDietGoal(fitnessGoal);
		sr.save(fitness);
	}
	
	// Returns all the users with their variables
	public Iterable<Gebruikers> getAll() {
		return sr.findAll();
	}

	
}
