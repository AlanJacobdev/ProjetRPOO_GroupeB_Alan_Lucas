package fourmis;

import etape.Oeuf;

public class Fourmis {

  Etape etape;

  public Fourmis() {
    this.etape = new Oeuf();
  }

  public Fourmis(Etape etape) {
    this.etape = etape;
  }

  public void step() {
    this.etape = etape.next();
    etape.step();
  }


}
