package fourmiliere;

public class SexueMale extends Sexue {

  Integer age;
  Integer esperanceVie;
  Fourmis fourmis;
  
  /**
   * Constructeur.
   * @param fourmis Fourmillière
   */
  public SexueMale(Fourmis fourmis) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.fourmis = fourmis;
  }

  @Override
  protected void step() {

  }

}
