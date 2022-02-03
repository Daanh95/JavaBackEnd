package nl.sportnut.voeding.gebruikers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event.ID;

import nl.sportnut.voeding.gebruikers.GebruikerRepository;
import nl.sportnut.voeding.model.Gebruiker;
import nl.sportnut.voeding.model.Scan;

@Service
public class GebruikerService {
	@Autowired
	GebruikerRepository gr; //Shortcut to the GebruikersRepository
	
	// The body from the endpoint goes through the methode and will be saved onto the SQL database.
	public Gebruiker create(Gebruiker mijnUser) { 
			
		// The Repository will be called and the new user will be saved upon the database via the save() function.
		gr.save(mijnUser);
			
		// Returns the saved user to the end point. 
		return gr.save(mijnUser);
	}
	
	// de body die wordt meegegeven update de details van dezelfde body die al bestaat.
	public Gebruiker updateClient(Gebruiker gebruikerDetails, long id) {
		
		// Finds the already existing user in the database and puts it into an object
		Gebruiker gebruiker = gr.findById(id).get();
		
		// Changes the old gender of the user to the newly updated one 
		gebruiker.setSexUser(gebruikerDetails.getSexUser());
		
		// If the password in the updated body did not change via the browser the SQL data of it will not change.
		if (gebruikerDetails.getPassword() == "") {
			gebruiker.getPassword();
		}else {
			// If the password in the updated body did change via the browser the SQL data of it will change to the new password.
			gebruiker.setPassword(gebruikerDetails.getPassword());
		}
		
		// If the username in the updated body did not change via the browser the SQL data of it will not change.
		if (gebruikerDetails.getUsername() == "") {
			gebruiker.getUsername();
		}else {
			// If the username in the updated body did change via the browser the SQL data of it will change to the new username.
			gebruiker.setUsername(gebruikerDetails.getUsername());
		}
		
		// If the weight in the updated body did not change via the browser the SQL data of it will not change.
		if (gebruikerDetails.getWeightUser() == 0) {
			gebruiker.getWeightUser();
		}else {
			// If the weight in the updated body did change via the browser the SQL data of it will change to the new weight.
			gebruiker.setWeightUser(gebruikerDetails.getWeightUser());
		}
		
		// If the length in the updated body did not change via the browser the SQL data of it will not change.
		if (gebruikerDetails.getLenghtUser() == 0) {
			gebruiker.getLenghtUser();
		}else {
			// If the length in the updated body did change via the browser the SQL data of it will change to the new lenghth.
			gebruiker.setLenghtUser(gebruikerDetails.getLenghtUser());
		}
		
		// If the FitnessGoal in the updated body did not change via the browser the SQL data of it will not change.
		if (gebruikerDetails.getFitnessGoal() == 0) {
			gebruiker.getFitnessGoal();
		}else {
			// If the FitnessGoal in the updated body did change via the browser the SQL data of it will change to the new goal.
			gebruiker.setFitnessGoal(gebruikerDetails.getFitnessGoal());
		}
		
		// If the Dietgoal in the updated body did not change via the browser the SQL data of it will not change
		if (gebruikerDetails.getDietGoal() == 0) {
			gebruiker.getDietGoal();
		}else {
			// If the Dietgoal in the updated body did change via the browser the SQL data of it will change to the new goal
			gebruiker.setDietGoal(gebruikerDetails.getDietGoal());
		}
		
		// If the age in the updated body did not change via the browser the SQL data of it will not change
		if (gebruikerDetails.getAgeUser() == null) {
			gebruiker.getAgeUser();
		}else {
			// If the age in the updated body did change via the browser the SQL data of it will change to the new age
			gebruiker.setAgeUser(gebruikerDetails.getAgeUser());
		}
		//Gebruiker updatedClient = gr.save(gebruiker);
		
		// Puts all the newly added data into the database by saving all the changes via the Repository. It then returns the updated user.
		gr.save(gebruiker);
		return gebruiker;
	}
	
	// Returns all the users with their variables
	public Iterable<Gebruiker> getAll() {
		return gr.findAll();
	}
	
	// Find a specific user in the SQL database.
	public Optional<Gebruiker> findUser(Long identification) {		
		var result = gr.findById(identification);
		return result;
	}
	
	// Saves an username for the user.
	public void createUserName (String username) {
		Gebruiker name = new Gebruiker();
		name.setUsername(username);
		gr.save(name);
	}
	
	// Saves a password for the user.
	public void createPassword (String password) {
		Gebruiker pass = new Gebruiker();
		pass.setPassword(password);
		gr.save(pass);
	}
	
	// Saves a diet goal for the user.
	public void createDietGoal(int dietGoal) {
		Gebruiker diet = new Gebruiker();
		diet.setDietGoal(dietGoal);
		gr.save(diet);
	}
	
	// Saves a weight for the user.
	public void createWeightUser(int weightUser) {
		Gebruiker weightU = new Gebruiker();
		weightU.setDietGoal(weightUser);
		gr.save(weightU);
	}
	
	// Saves a length for the user.
	public void createLenghtUser(int lenghtUser) {
		Gebruiker lenghtU = new Gebruiker();
		lenghtU.setDietGoal(lenghtUser);
		gr.save(lenghtU);
	}
	
	// Saves an age for the user.
	public void createAgeUser(int ageUser) {
		Gebruiker age = new Gebruiker();
		age.setDietGoal(ageUser);
		gr.save(age);
	}
	
	// Saves a sex for the user.
	public void createSexUser(int sexUser) {
		Gebruiker sex = new Gebruiker();
		sex.setDietGoal(sexUser);
		gr.save(sex);
	}
	
	// Saves a fitness goal for the user.
	public void createFitnessGoal(int fitnessGoal) {
		Gebruiker fitness = new Gebruiker();
		fitness.setDietGoal(fitnessGoal);
		gr.save(fitness);
	}	
}
