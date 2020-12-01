package fourmiliere;

public class SexueFemelle extends Sexue {
  Integer age;
  Integer esperanceVie;
  Fourmiliere saFourmiliere;

  /**
   * Constructeur.
   * 
   * @param laFourmiliere Fourmilliere
   */
  public SexueFemelle(Fourmiliere laFourmiliere) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.saFourmiliere = laFourmiliere;
  }

  @Override
  protected void step() {

  }

}
