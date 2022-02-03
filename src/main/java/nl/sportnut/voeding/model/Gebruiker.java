package nl.sportnut.voeding.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gebruiker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	String username;
	private String password;
	private int weightUser;
	private int lenghtUser;
	private LocalDate ageUser;
	private boolean sexUser;
	private int dietGoal;
	private int fitnessGoal;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getWeightUser() {
		return weightUser;
	}
	public void setWeightUser(int weightUser) {
		this.weightUser = weightUser;
	}
	
	public int getLenghtUser() {
		return lenghtUser;
	}
	public void setLenghtUser(int lenghtUser) {
		this.lenghtUser = lenghtUser;
	}
	
	public LocalDate getAgeUser() {
		return ageUser;
	}
	public void setAgeUser(LocalDate ageUser) {
		this.ageUser = ageUser;
	}
	
	public boolean getSexUser() {
		return sexUser;
	}
	public void setSexUser(boolean sexUser) {
		this.sexUser = sexUser;
	}
	
	public int getDietGoal() {
		return dietGoal;
	}
	public void setDietGoal(int dietGoal) {
		this.dietGoal = dietGoal;
	}
	
	public int getFitnessGoal() {
		return fitnessGoal;
	}
	public void setFitnessGoal(int fitnessGoal) {
		this.fitnessGoal = fitnessGoal;
	}

	
	
}
