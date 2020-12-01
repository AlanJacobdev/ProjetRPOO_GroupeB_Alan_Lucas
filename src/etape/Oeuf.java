package etape;

import environnement.Fourmiliere;
import fourmis.Etape;
import fourmis.Role;

public class Oeuf extends Etape {

  Integer age;
  Integer joursAvantLarve = 10;
  Fourmiliere laFourmiliere;

  /**
   * Constructeur d'un oeuf.
   * @param fourmiliere La fourmilière.
   */
  public Oeuf(Fourmiliere fourmiliere) {
    super();
    age = 0;
    this.laFourmiliere = fourmiliere;
    this.laFourmiliere.incrementerOeufs();
  }

  public void step() {
    age++;
  }

  @Override
  protected Etape next() {
    if (this.age == this.joursAvantLarve) {
      this.laFourmiliere.decrementerOeufs();
      return new Larve(this.laFourmiliere);
    }
    return this;
  }

  @Override
  protected Role getRole() {
    return null;
  }

}
