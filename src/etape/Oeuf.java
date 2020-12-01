package etape;

import fourmis.Etape;
import fourmis.Role;

public class Oeuf extends Etape {

  Integer age;
  Integer joursAvantLarve = 10;

  public Oeuf() {
    age = 0;
  }


  public void step() {
    age++;
  }



  @Override
  protected Etape next() {
    if (this.age == this.joursAvantLarve) {
      return new Larve();
    }
    return this;
  }



  @Override
  protected Role getRole() {
    return null;
  }

}
