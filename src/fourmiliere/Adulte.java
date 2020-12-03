package fourmiliere;

import environnement.InformationsFourmiliere;
import java.awt.Point;

public class Adulte extends Etape {
  
  static final int minimumPopulation = 0;
  static final int maximalPopulationOuvriere = 65;
  static final int maximalPopulationSoldat = 85;
  static final int maximalPopulation = 100;
  protected Role roleFourmis;
  protected Fourmis fourmis;
  protected Point coordonneesActuelle;
  protected FourmisGraphique representationGraphique;
  

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
      this.representationGraphique = new FourmisGraphique(this.fourmis);
    }
  }

  public FourmisGraphique getRepresentationGraphique() {
    return this.representationGraphique;
  }

  public Fourmis getFourmis() {
    return this.fourmis;
  }

  @Override
  protected Role getRole() {
    return this.roleFourmis;
  }

  /**
   * Attribue un rôle à une fourmis adulte.
   * @return le Role de la fourmis.
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

  /**
   * Déplacement aléatoire de la fourmis.
   */
  public void prochainePosition() {
    this.representationGraphique.prochainePosition();
  }

  @Override
  protected Etape next() {
    return this.getRole().mourir();
  }

  @Override
  protected void step() {
    this.getRole().step();
    if (!(this.getRole() instanceof Reine)) {
      this.prochainePosition();
    }
  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    this.fourmis.getRole().renseignerInformations(infos);
  }



}
