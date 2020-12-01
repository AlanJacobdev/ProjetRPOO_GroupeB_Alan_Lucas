package fourmiliere;

public class Adulte extends Etape {

  Role roleFourmis;

  Fourmis fourmis;

  static int minimumPopulation = 0;
  static int maximalPopulationOuvriere = 65;
  static int maximalPopulationSoldat = 85;
  static int maximalPopulation = 100;

  /**
   * Adulte.
   * 
   */
  public Adulte(Fourmis fourmis) {
    super();
    this.fourmis = fourmis;
    this.roleFourmis = this.creerRole();
  }

 
  
  /**
   * Attribue un rôle à une fourmis adulte.
   */
  public Role creerRole() {
    int categorieFourmis = (int) (Math.random() * (maximalPopulation - minimumPopulation));
    if (categorieFourmis < maximalPopulationOuvriere) {
      return new Ouvrier(this.fourmis);
    }
    if (categorieFourmis < maximalPopulationSoldat) {
      return new Soldat(this.fourmis);
    }
    if ((boolean) (Math.random() > 0.5 ? 1 : 2 == 1)) {
      return new SexueMale(this.fourmis);
    }
    return new SexueFemelle(this.fourmis);
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

  @Override
  protected void step() {
    this.getRole().step();
    
  }

}
