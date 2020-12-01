package fourmis;

import etape.Oeuf;

public abstract class Etape {

  Etape etape;
  Integer nbJour;

  public Etape() {
    this.etape = new Oeuf();

  }

  protected abstract Etape next();

  protected abstract void step();
  
  protected abstract Role getRole();

}
