package nl.sportnut.voeding.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	LocalDateTime scanMoment;
	String barcode;
	String productnaam;
	int prijs;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getScanMoment() {
		return scanMoment;
	}
	public void setScanMoment(LocalDateTime scanMoment) {
		this.scanMoment = scanMoment;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getProductnaam() {
		return productnaam;
	}
	public void setProductnaam(String productnaam) {
		this.productnaam = productnaam;
	}
	public int getPrijs() {
		return prijs;
	}
	public void setPrijs(int prijs) {
		this.prijs = prijs;
	}
	
	
}
