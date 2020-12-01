package role;

import environnement.Fourmiliere;

public class SexueMale extends Sexue {

  Integer age;
  Integer esperanceVie;
  Fourmiliere saFourmiliere;
  
  /**
   * Constructeur.
   * @param laFourmiliere Fourmillière
   */
  public SexueMale(Fourmiliere laFourmiliere) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.saFourmiliere = laFourmiliere;
  }

  @Override
  protected void step() {

  }

}
