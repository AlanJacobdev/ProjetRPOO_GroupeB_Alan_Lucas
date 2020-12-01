package fourmiliere;

public class Soldat extends Role {
  Integer age;
  Integer esperanceVie;
  Fourmis fourmis;
  
  /**
   * Constructeur.
   * @param fourmis Fourmilliere 
   */
  public Soldat(Fourmis fourmis) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.fourmis = fourmis;
  }

  @Override
  protected void step() {

  }

}
