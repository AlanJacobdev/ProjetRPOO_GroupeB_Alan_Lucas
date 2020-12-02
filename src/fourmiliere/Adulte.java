package fourmiliere;

import environnement.InformationsFourmiliere;
import graphicLayer.GOval;
import java.awt.Point;



public class Adulte extends Etape {

  protected Role roleFourmis;

  protected Fourmis fourmis;
  protected Point coordonneesActuelle;
  protected GOval representationGraphique;
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

      this.coordonneesActuelle =
          new Point(this.getFourmis().getFourmiliere().getPositionFourmiliere().x + 5,
              this.getFourmis().getFourmiliere().getPositionFourmiliere().y + 5);
      this.representationGraphique = new GOval();
      this.representationGraphique.setPosition(coordonneesActuelle);
      this.getFourmis().getFourmiliere().getLeTerrain()
          .ajouterFourmisGraphique(representationGraphique);
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

  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    this.fourmis.getRole().renseignerInformations(infos);
  }

  /**
   * Déplacement aléatoire de la fourmis.
   * 
   * @return la coordonnée
   */
  public Point prochainePosition() {
    int deplacement = (int) (Math.random() * (100 - 0));
    if (!(coordonneesActuelle.x > this.getFourmis().getFourmiliere().getPositionFourmiliere().x
        + 200
        || coordonneesActuelle.y > this.getFourmis().getFourmiliere().getPositionFourmiliere().y
            + 200)) {
      if (deplacement <= 25) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x, coordonneesActuelle.y + 1));
      }
      if (deplacement <= 50) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x, coordonneesActuelle.y - 1));
      }
      if (deplacement <= 75) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x + 1, coordonneesActuelle.y));
      }
      if (deplacement <= 100) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x - 1, coordonneesActuelle.y));
      }
    }
    return coordonneesActuelle;

  }



}
