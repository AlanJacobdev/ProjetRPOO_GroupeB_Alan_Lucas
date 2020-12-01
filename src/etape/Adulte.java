package etape;

import fourmis.Etape;
import fourmis.Role;
import role.Ouvrier;
import role.Sexue;
import role.Soldat;

public class Adulte extends Etape {

  Role roleFourmis;

  static int minimumPopulationOuvriere = 0;
  static int maximalPopulationOuvriere = 65;
  static int minimumPopulationSoldat = 65;
  static int maximalPopulationSoldat = 85;
  static int minimumPopulationSexue = 85;
  static int maximalPopulationSexue = 100;

  public Adulte() {
    this.roleFourmis = this.creerRole();
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
    return new Sexue();
  }

}
