package fourmiliere;

public class Nymphe extends Etape {

  Integer age;
  Integer joursAvantFourmis = 10;
  Fourmis fourmis;

  /**
   * Constructeur d'une nymphe.
   * 
   * @param fourmis La fourmilière.
   */
  public Nymphe(Fourmis fourmis) {
    age = 0;
    this.fourmis = fourmis;
    this.fourmis.getFourmiliere().getInfos().incrementerNymphes();
  }

  @Override
  protected Etape next() {
    if (age == joursAvantFourmis) {
      this.fourmis.getFourmiliere().getInfos().decrementerNymphes();
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
}
