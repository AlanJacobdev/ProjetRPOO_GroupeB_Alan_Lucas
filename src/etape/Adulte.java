package etape;

import fourmis.Etape;
import fourmis.Role;
import role.Ouvrier;
import role.SexueFemelle;
import role.SexueMale;
import role.Soldat;

public class Adulte extends Etape {

  Role roleFourmis;
  Integer age;
  Integer esperanceDeVie;
  
  static int minimumPopulationOuvriere = 0;
  static int maximalPopulationOuvriere = 65;
  static int minimumPopulationSoldat = 65;
  static int maximalPopulationSoldat = 85;
  static int minimumPopulationSexue = 85;
  static int maximalPopulationSexue = 100;

  public Adulte() {
    this.roleFourmis = this.creerRole();
    this.age = 0;
    this.esperanceDeVie = 
  }



  public void step() {

  }

  /**
   * Attribue un rôle à une fourmis adulte.
   */
  public Role creerRole() {
    int categorieFourmis =
        (int) (Math.random() * (maximalPopulationSexue - minimumPopulationOuvriere));
    if (categorieFourmis < maximalPopulationOuvriere) {
      return new Ouvrier();
    }
    if (categorieFourmis < maximalPopulationSoldat) {
      return new Soldat();
    }
    if ((boolean) (Math.random() > 0.5 ? 1 : 2 == 1)) {
      return new SexueMale();
    }
    return new SexueFemelle();
  }

}
