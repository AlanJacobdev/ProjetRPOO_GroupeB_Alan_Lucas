package etape;

import fourmis.Etape;
import fourmis.Role;

public class Larve extends Etape {

  Integer age;
  Integer joursAvantNymphe = 10;
  
  public Larve() {
    age = 0;
  }

  
  
  public void step() {
    age++;
  }



  @Override
  protected Etape next() {
    if (this.age == this.joursAvantNymphe) {
      return new Nymphe();
    }
    return null;
  }



  @Override
  protected Role getRole() {
    // TODO Auto-generated method stub
    return null;
  }

}
