package fourmiliere;

import graphicLayer.GOval;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class FourmisGraphique {

  Fourmis laFourmis;
  private Point coordonneesActuelle;
  private GOval representationGraphique;

  /**
   * Constructio de l'aspect graphique d'une fourmis adulte.
   * 
   * @param fourmis La fourmis réelle
   */
  public FourmisGraphique(Fourmis fourmis) {
    this.laFourmis = fourmis;
    this.coordonneesActuelle =
        new Point(this.getFourmis().getFourmiliere().getPositionFourmiliere().x,
            this.getFourmis().getFourmiliere().getPositionFourmiliere().y);
    this.representationGraphique = new GOval();
    this.representationGraphique.setPosition(coordonneesActuelle);
    this.representationGraphique.setDimension(new Dimension(5, 5));
    this.getFourmis().getFourmiliere().getLeTerrain()
        .ajouterFourmisGraphique(representationGraphique);
  }

  private Fourmis getFourmis() {
    return this.laFourmis;
  }


  private Boolean dansFourmiliere() {
    if (this.coordonneesActuelle.x > this.getFourmis().getFourmiliere().getPositionFourmiliere().x
        - 5
        && this.coordonneesActuelle.x < this.getFourmis().getFourmiliere()
            .getPositionFourmiliere().x + 20
        && this.coordonneesActuelle.y > this.getFourmis().getFourmiliere()
            .getPositionFourmiliere().y - 5
        && this.coordonneesActuelle.y < this.getFourmis().getFourmiliere()
            .getPositionFourmiliere().y + 20) {
      return true;
    } else {
      return false;
    }
  }
  
  private Boolean dansTerritoire() {
    if (coordonneesActuelle.x < this.getFourmis().getFourmiliere().getPositionFourmiliere().x
        + 200
        || coordonneesActuelle.y < this.getFourmis().getFourmiliere().getPositionFourmiliere().y
            + 200) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Déplacement aléatoire de la fourmis.
   * 
   */
  public void prochainePosition() {
    if (this.coordonneesActuelle != null) {
      int deplacement = (int) (Math.random() * (100 - 0));
      if (this.dansTerritoire()) {
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
        if (this.dansFourmiliere()) {
          this.representationGraphique.setColor(Color.red);
        } else {
          this.representationGraphique.setColor(Color.blue);
        }
      }
    }
  }
}
