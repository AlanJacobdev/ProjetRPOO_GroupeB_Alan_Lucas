package fourmiliere;

import environnement.InformationsFourmiliere;

public class Oeuf extends Etape {

  Integer age;
  Integer joursAvantLarve = 3;
  Fourmis fourmis;

  /**
   * Constructeur d'un oeuf.
   *
   * @param fourmis la fourmis.
   */
  public Oeuf(Fourmis fourmis) {
    age = 0;
    this.fourmis = fourmis;
  }

  public void step() {
    age++;
  }

  @Override
  protected Etape next() {
    if (this.age == this.joursAvantLarve) {
      return new Larve(this.fourmis);
    }
    return this;
  }

  @Override
  protected Role getRole() {
    return null;
  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.incrementerOeufs();
  }


}
