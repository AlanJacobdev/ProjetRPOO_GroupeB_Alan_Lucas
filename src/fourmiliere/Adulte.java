package fourmiliere;

import environnement.InformationsFourmiliere;
import graphicLayer.GOval;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;



public class Adulte extends Etape {

  protected Role roleFourmis;

  protected Fourmis fourmis;
  protected Point coordonneesActuelle;
  protected FourmisGraphique representationGraphique;
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
      this.representationGraphique = new FourmisGraphique(this.fourmis);
    }
  }



  /**
   * Attribue un rôle à une fourmis adulte.
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
    if (!(this.getRole() instanceof Reine)) {
      this.prochainePosition();
    }
  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    this.fourmis.getRole().renseignerInformations(infos);
  }

  /**
   * Déplacement aléatoire de la fourmis.
   * 
   */
  public void prochainePosition() {
    this.representationGraphique.prochainePosition();
  }

  public FourmisGraphique getRepresentationGraphique() {
    return this.representationGraphique;
  }

}
