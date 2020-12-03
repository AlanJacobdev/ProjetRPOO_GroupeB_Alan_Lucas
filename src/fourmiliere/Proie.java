package fourmiliere;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GRect;

public class Proie {
  private Dimension taille;
  private Dimension tailleTerrain;
  private Point positionActuelle;
  private GRect representationGraphique;

  /**
   * Constructeur Proie.
   * 
   * @param tailleTerrain .
   * 
   */
  public Proie(Dimension tailleTerrain) {
    this.tailleTerrain = tailleTerrain;
    int x = (int) (Math.random() * (500 - 0));
    int y = (int) (Math.random() * (500 - 0));
    this.positionActuelle = new Point(x, y);
    this.representationGraphique = new GRect();
    this.representationGraphique.setColor(Color.ORANGE);
    this.representationGraphique.setDimension(new Dimension(10, 10));
    this.representationGraphique.setPosition(positionActuelle);
  }

  public Point getPositionActuelle() {
    return positionActuelle;
  }

  public void setPositionActuelle(Point positionActuelle) {
    this.positionActuelle = positionActuelle;
  }

  public GRect getRepresentationGraphique() {
    return representationGraphique;
  }

  public void setRepresentationGraphique(GRect representationGraphique) {
    this.representationGraphique = representationGraphique;
  }


}
