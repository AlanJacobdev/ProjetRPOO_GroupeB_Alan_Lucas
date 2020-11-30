package fourmis;

import etape.Oeuf;

public class Fourmi {

	Etape etape;

	public Fourmi() {
		this.etape = new Oeuf();
	}
	
	
	public void step() {
		this.etape = etape.next();
		etape.step();
	}
	
	
}
