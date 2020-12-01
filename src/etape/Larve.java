package etape;

import environnement.Fourmiliere;
import fourmis.Etape;
import fourmis.Role;

public class Larve extends Etape {

  Integer age;
  Integer joursAvantNymphe = 10;
  Fourmiliere laFourmiliere;
  
  /**
   * Constructeur d'une larve.
   * @param fourmiliere La fourmilière.
   */
  public Larve(Fourmiliere fourmiliere) {
    age = 0;
    this.laFourmiliere = fourmiliere;
    this.laFourmiliere.incrementerLarves();
  }

  
  
  public void step() {
    age++;
  }



  @Override
  protected Etape next() {
    if (this.age == this.joursAvantNymphe) {
      this.laFourmiliere.decrementerLarves();
      return new Nymphe(this.laFourmiliere);
    }
    return null;
  }



  @Override
  protected Role getRole() {
    // TODO Auto-generated method stub
    return null;
  }

}
