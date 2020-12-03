package fourmiliere;

import environnement.InformationsFourmiliere;

public class Oeuf extends Etape {

  protected int age;
  protected final int joursAvantLarve = 3;
  protected Fourmis fourmis;

  /**
   * Constructeur d'un oeuf.
   * 
   * @param fourmis La fourmilière.
   */
  public Oeuf(Fourmis fourmis) {
    age = 0;
    this.fourmis = fourmis;
  }
  
  @Override
  protected void step() {
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
