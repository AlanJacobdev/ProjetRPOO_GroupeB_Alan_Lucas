package etape;

import fourmis.Etape;
import fourmis.Role;
import role.Ouvrier;
import role.Reine;
import role.Sexue;
import role.SexueFemelle;
import role.SexueMale;
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
    super();
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
    if ((boolean) (Math.random() > 0.5 ? 1 : 2 == 1)) {
      return new SexueMale();
    }
    return new SexueFemelle();
  }

  public void attributionRoleReine() {
    this.roleFourmis = new Reine();
  }

  @Override
  protected Role getRole() {
    return this.roleFourmis;
  }

  @Override
  protected Etape next() {
    return this;
  }

}
