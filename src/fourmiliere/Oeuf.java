package fourmiliere;

public class Oeuf extends Etape {

  Integer age;
  Integer joursAvantLarve = 3;
  Fourmis fourmis;

  /**
   * Constructeur d'un oeuf.
   * @param fourmis La fourmilière.
   */
  public Oeuf(Fourmis fourmis) {
    age = 0;
    this.fourmis = fourmis;
    if (this.fourmis.getFourmiliere() != null) {

    }
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
  protected void renseignerInformations() {
    this.fourmis.getFourmiliere().getInfos().incrementerOeufs();
  }

}
