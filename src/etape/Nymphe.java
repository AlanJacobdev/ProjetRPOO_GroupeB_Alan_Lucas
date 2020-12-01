package etape;

import environnement.Fourmiliere;
import fourmis.Etape;
import fourmis.Role;

public class Nymphe extends Etape {

  Integer age;
  Integer joursAvantFourmis = 10;
  Fourmiliere laFourmiliere;

  /**
   * Constructeur d'une nymphe.
   * 
   * @param fourmiliere La fourmilière.
   */
  public Nymphe(Fourmiliere fourmiliere) {
    age = 0;
    this.laFourmiliere = fourmiliere;
    this.laFourmiliere.incrementerNymphes();
  }

  @Override
  protected Etape next() {
    if (age == joursAvantFourmis) {
      this.laFourmiliere.decrementerNymphes();
      return new Adulte(this.laFourmiliere);
    }
    return this;
  }

  @Override
  protected Role getRole() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected void step() {
    age++;
  }
}
