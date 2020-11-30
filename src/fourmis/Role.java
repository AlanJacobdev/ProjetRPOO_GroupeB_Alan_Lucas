package fourmis;

import role.Ouvrier;
import role.Sexue;
import role.Soldat;

public abstract class Role {

  protected abstract void step();

  protected int minimumPopulationOuvriere = 0;
  protected int maximalPopulationOuvriere = 65;

  protected int minimumPopulationSoldat = 65;
  protected int maximalPopulationSoldat = 85;

  protected int minimumPopulationSexue = 85;
  protected int maximalPopulationSexue = 100;


  /**
   * Attribue un rôle à une fourmis adulte.
   */
  public Role attribuerRole() {
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
