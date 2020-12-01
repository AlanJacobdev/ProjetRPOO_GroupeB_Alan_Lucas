package fourmiliere;

public class Larve extends Etape {

  Integer age;
  Integer joursAvantNymphe = 10;
  Fourmis fourmis;

  /**
   * Constructeur d'une larve.
   * 
   * @param fourmis La fourmilière.
   */
  public Larve(Fourmis fourmis) {
    age = 0;
    this.fourmis = fourmis;
  }


  @Override
  protected Etape next() {
    if (this.age == this.joursAvantNymphe) {
      return new Nymphe(this.fourmis);
    }
    return null;
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
