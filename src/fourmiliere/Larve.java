package fourmiliere;

public class Larve extends Etape {

  Integer age;
  Integer joursAvantNymphe = 10;
  Fourmiliere laFourmiliere;
  
  /**
   * Constructeur d'une larve.
   * @param fourmiliere La fourmilière.
   */
  public Larve(Fourmiliere fourmiliere) {
    age = 0;
    this.laFourmiliere = fourmiliere;
    this.laFourmiliere.incrementerLarves();
  }


  @Override
  protected Etape next() {
    if (this.age == this.joursAvantNymphe) {
      this.laFourmiliere.decrementerLarves();
      return new Nymphe(this.laFourmiliere);
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
