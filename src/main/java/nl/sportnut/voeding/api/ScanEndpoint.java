package nl.sportnut.voeding.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.sportnut.voeding.controller.ScanService;
import nl.sportnut.voeding.model.Scan;

@RestController
@CrossOrigin(maxAge = 3600)
public class ScanEndpoint {
	private static final Scan String = null;
	@Autowired
	ScanService scs;
	@GetMapping("/herewego")
	public void herewego() {
		System.out.println("Hij doet het");
		scs.slahetmaarop();
	}
	
	@GetMapping("/herewego2")
	public int herewego2() {
		System.out.println("Hij doet het");
		return 12;
	}
	
	@GetMapping("/herewego3")
	public String herewego3() {
		System.out.println("Hij doet het");
		return "Dit is een tekst";
	}
	
	@GetMapping("/herewego4")
	public Scan herewego4() {
		System.out.println("Hij doet het");
		Scan mijnScan = new Scan();
		mijnScan.setBarcode("32432432");
		mijnScan.setPrijs(450);
		mijnScan.setScanMoment(LocalDateTime.now());
		mijnScan.setProductnaam("Boterham");
		return mijnScan;
	}
	
	@GetMapping("/herewego5/{barcode}")
	public java.lang.String herewego5(@PathVariable String barcode) {
		scs.abc(barcode);
		return barcode;
	}
	
	@GetMapping("/doemijhetproduct/{productnaam}/{deprijs}")
	public Scan herewego6(@PathVariable String productnaam, @PathVariable int deprijs, @RequestParam String zomaar) {
		System.out.println("Hij doet het");
		Scan mijnScan = new Scan();
		mijnScan.setBarcode(zomaar);
		mijnScan.setPrijs(deprijs);
		mijnScan.setScanMoment(LocalDateTime.now());
		mijnScan.setProductnaam(productnaam);
		return mijnScan;
	}
	
	@GetMapping ("/alles")
	public Iterable<Scan> A () {
		return scs.getAll();
	}
	
	
}
