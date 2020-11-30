package fourmis;

import etape.Oeuf;

public class Fourmis {

  Etape etape;

  public Fourmis() {
    this.etape = new Oeuf();
  }


  public void step() {
    this.etape = etape.next();
    etape.step();
  }


}
