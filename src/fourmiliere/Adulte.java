package fourmiliere;

public class Adulte extends Etape {

  protected Role roleFourmis;

  protected Fourmis fourmis;

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
    if (fourmis.saFourmiliere != null) {
      this.roleFourmis = this.creerRole();
    }
  }

 
  
  /**
   * Attribue un rôle à une fourmis adulte.
   */
  public Role creerRole() {
    int categorieFourmis = (int) (Math.random() * (maximalPopulation - minimumPopulation));
    if (categorieFourmis < maximalPopulationOuvriere) {
      this.fourmis.getFourmiliere().getInfos().incrementerOuvrieres();
      return new Ouvrier(this);
    }
    if (categorieFourmis < maximalPopulationSoldat) {
      this.fourmis.getFourmiliere().getInfos().incrementerSoldats();
      return new Soldat(this);
    }
    if ((boolean) (Math.random() > 0.5 ? 1 : 2 == 1)) {
      this.fourmis.getFourmiliere().getInfos().incrementerSexueMale();
      return new SexueMale(this);
    }
    this.fourmis.getFourmiliere().getInfos().incrementerSexueFemelle();
    return new SexueFemelle(this);
  }

  public void attributionRoleReine() {
    this.roleFourmis = new Reine(this);
  }

  public Fourmis getFourmis() {
    return this.fourmis;
  }
  
  @Override
  protected Role getRole() {
    return this.roleFourmis;
  }

  @Override
  protected Etape next() {
    return this.getRole().mourrir();
  }

  @Override
  protected void step() {
    this.getRole().step();
    
  }

}
