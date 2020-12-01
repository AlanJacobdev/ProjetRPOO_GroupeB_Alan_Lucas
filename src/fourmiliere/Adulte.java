package fourmiliere;

public class Adulte extends Etape {

  Role roleFourmis;

  Fourmiliere laFourmiliere;

  static int minimumPopulation = 0;
  static int maximalPopulationOuvriere = 65;
  static int maximalPopulationSoldat = 85;
  static int maximalPopulation = 100;

  /**
   * Adulte.
   * 
   */
  public Adulte(Fourmiliere fourmiliere) {
    super();
    this.laFourmiliere = fourmiliere;
    this.roleFourmis = this.creerRole();
  }

 
  
  /**
   * Attribue un rôle à une fourmis adulte.
   */
  public Role creerRole() {
    int categorieFourmis = (int) (Math.random() * (maximalPopulation - minimumPopulation));
    if (categorieFourmis < maximalPopulationOuvriere) {
      this.laFourmiliere.incrementerOuvrieres();
      return new Ouvrier(laFourmiliere);
    }
    if (categorieFourmis < maximalPopulationSoldat) {
      this.laFourmiliere.incrementerSoldats();
      return new Soldat(laFourmiliere);
    }
    if ((boolean) (Math.random() > 0.5 ? 1 : 2 == 1)) {
      this.laFourmiliere.incrementerSexueMale();
      return new SexueMale(laFourmiliere);
    }
    this.laFourmiliere.incrementerSexueFemelle();
    return new SexueFemelle(laFourmiliere);
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
