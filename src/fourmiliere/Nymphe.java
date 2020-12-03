package fourmiliere;

import environnement.InformationsFourmiliere;

public class Nymphe extends Etape {

  protected int  age;
  protected final int joursAvantFourmis = 10;
  protected Fourmis fourmis;

  /**
   * Constructeur d'une nymphe.
   * 
   * @param fourmis La fourmis.
   */
  public Nymphe(Fourmis fourmis) {
    this.age = 0;
    this.fourmis = fourmis;
  }

  @Override
  protected Etape next() {
    if (age == joursAvantFourmis) {
      return new Adulte(this.fourmis);
    }
    return this;
  }

  @Override
  protected Role getRole() {
    return null;
  }

  @Override
  protected void step() {
    age++;
  }
  
  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.incrementerNymphes();
  }
  
}
