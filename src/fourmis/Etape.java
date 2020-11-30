package fourmis;

import etape.Oeuf;

public abstract class Etape {

  Etape etape;
  Integer nbJour;

  public Etape() {
    this.etape = new Oeuf();

  }

  Etape next() {
    nbJour++;
    return this;
  }

  protected abstract void step();

}
