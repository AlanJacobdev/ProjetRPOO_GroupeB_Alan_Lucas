package role;

import environnement.Fourmiliere;
import fourmis.Role;

public class Soldat extends Role {
  Integer age;
  Integer esperanceVie;
  Fourmiliere saFourmiliere;
  
  /**
   * Constructeur.
   * @param laFourmiliere Fourmilliere 
   */
  public Soldat(Fourmiliere laFourmiliere) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.saFourmiliere = laFourmiliere;
  }

  @Override
  protected void step() {

  }

}
