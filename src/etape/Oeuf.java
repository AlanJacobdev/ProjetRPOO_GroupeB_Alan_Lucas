package etape;

import fourmis.Etape;
import fourmis.Role;

public class Oeuf extends Etape {


  public Oeuf() {

  }



  public void step() {

  }



  @Override
  protected Etape next() {
    return this;
  }



  @Override
  protected Role getRole() {
    return null;
  }

}
