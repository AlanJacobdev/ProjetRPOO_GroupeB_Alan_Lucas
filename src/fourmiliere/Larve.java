package fourmiliere;

import environnement.InformationsFourmiliere;

public class Larve extends Etape {

  protected int age;
  protected final int joursAvantNymphe = 10;
  protected Fourmis fourmis;

  /**
   * Constructeur d'une larve.
   * 
   * @param fourmis La fourmis.
   */
  public Larve(Fourmis fourmis) {
    this.age = 0;
    this.fourmis = fourmis;
  }


  @Override
  protected Etape next() {
    if (this.age >= this.joursAvantNymphe) {
      return new Nymphe(this.fourmis);
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
    infos.incrementerLarves();
  }
  
 
  
}
