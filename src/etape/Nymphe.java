package etape;

import fourmis.Etape;
import fourmis.Role;

public class Nymphe extends Etape {

  Integer age;
  Integer joursAvantFourmis = 10;
  
  public Nymphe() {
    age = 0;
  }

  public void step() {
    age++;
  }

  @Override
  protected Etape next() {
    if (age == joursAvantFourmis) {
      return new Adulte(false);
    }
    return this;
  }

  @Override
  protected Role getRole() {
    // TODO Auto-generated method stub
    return null;
  }
}
