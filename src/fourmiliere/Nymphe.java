package fourmiliere;

import environnement.InformationsFourmiliere;

public class Nymphe extends Etape {

  Integer age;
  Integer joursAvantFourmis = 10;
  Fourmis fourmis;

  /**
   * Constructeur d'une nymphe.
   *
   * @param fourmis la fourmis.
   */
  public Nymphe(Fourmis fourmis) {
    age = 0;
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
