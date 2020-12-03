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
          new Point(this.getFourmis().getFourmiliere().getPositionFourmiliere().x,
              this.getFourmis().getFourmiliere().getPositionFourmiliere().y);
      this.representationGraphique = new GOval();
      this.representationGraphique.setPosition(coordonneesActuelle);
      this.representationGraphique.setDimension(new Dimension(10, 10));
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
    if (this.coordonneesActuelle != null) {
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
    int deplacement = (int) (Math.random() * (100 - 0));
    if (!(coordonneesActuelle.x > this.getFourmis().getFourmiliere().getPositionFourmiliere().x
        + 200
        || coordonneesActuelle.y > this.getFourmis().getFourmiliere().getPositionFourmiliere().y
            + 200)) {
      if (deplacement <= 25) {
        this.coordonneesActuelle = new Point(coordonneesActuelle.x, coordonneesActuelle.y + 5);
        this.representationGraphique.setPosition(coordonneesActuelle);
      } else if (deplacement <= 50) {
        this.coordonneesActuelle = new Point(coordonneesActuelle.x, coordonneesActuelle.y - 5);
        this.representationGraphique.setPosition(coordonneesActuelle);
      } else if (deplacement <= 75) {
        this.coordonneesActuelle = new Point(coordonneesActuelle.x + 5, coordonneesActuelle.y);
        this.representationGraphique.setPosition(coordonneesActuelle);
      } else if (deplacement <= 100) {
        this.coordonneesActuelle = new Point(coordonneesActuelle.x - 5, coordonneesActuelle.y);
        this.representationGraphique.setPosition(coordonneesActuelle);
      }

      if (this.coordonneesActuelle.x > this.getFourmis().getFourmiliere().getPositionFourmiliere().x
          - 5
          && this.coordonneesActuelle.x < this.getFourmis().getFourmiliere()
              .getPositionFourmiliere().x + 15
          && this.coordonneesActuelle.y > this.getFourmis().getFourmiliere()
              .getPositionFourmiliere().y - 5
          && this.coordonneesActuelle.y < this.getFourmis().getFourmiliere()
              .getPositionFourmiliere().y + 15) {
        this.representationGraphique.setColor(Color.red);
      } else {
        this.representationGraphique.setColor(Color.blue);
      }
    }
  }



}
