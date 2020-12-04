package fourmiliere;

import environnement.InformationsFourmiliere;

public class Adulte extends Etape {

  protected Role roleFourmis;

  protected Fourmis fourmis;

  static int minimumPopulation = 0;
  static int maximalPopulationOuvriere = 65;
  static int maximalPopulationSoldat = 85;
  static int maximalPopulation = 100;

  /**
   * Constructeur permettant de faire évoluer une fourmis en adulte.
   *
   * @param fourmis Une fourmis
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
   @return le Role de la fourmis.
   */
  public Role creerRole() {
    int categorieFourmis = (int) (Math.random() * (maximalPopulation - minimumPopulation));
    if (categorieFourmis < maximalPopulationOuvriere) {
      return new Ouvrier(this);
    }
    if (categorieFourmis < maximalPopulationSoldat) {
      return new Soldat(this);
    }
    if ((Math.random() > 0.5 ? 1 : 2) == 1) {
      return new SexueMale(this);
    }
    return new SexueFemelle(this);
  }

  /**
   * Forcer le role d'une fourmis à reine.
   */
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

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    this.fourmis.getRole().renseignerInformations(infos);
  }
}
