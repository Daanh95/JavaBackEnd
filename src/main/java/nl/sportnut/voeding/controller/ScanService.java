package nl.sportnut.voeding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.sportnut.voeding.model.Scan;

@Service
public class ScanService {
	@Autowired
	ScanRepository sr;
	private String barcode; 
	
	public void slahetmaarop() {
		sr.save(new Scan());
	}
	
	public void abc(String barcode) {
		Scan scan = new Scan();
		scan.setBarcode(barcode);
		sr.save(scan);
	}
	
	public Iterable<Scan> getAll() {
		return sr.findAll();
	}
	
}
