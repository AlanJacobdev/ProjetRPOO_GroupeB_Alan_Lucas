package fourmiliere;

public class Ouvrier extends Role {
  Integer age;
  Integer esperanceVie;
  Fourmis fourmis;

  /**
   * Constructeur.
   * 
   * @param fourmis Fourmiliere
   */
  public Ouvrier(Fourmis fourmis) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.fourmis = fourmis;
  }

  @Override
  protected void step() {

  }

}
