package vue;

import fourmiliere.Fourmis;
import graphicLayer.GOval;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class VueFourmis {

  Fourmis fourmis;
  Point coordonnees;
  GOval fourmisGraphique;

  /**
   * Constructeur d'une fourmi d'un point de vue graphique.
   * 
   */
  public VueFourmis(Point position) {
    this.fourmisGraphique = new GOval();
    this.fourmisGraphique.setDimension(new Dimension(10, 10));
    this.fourmisGraphique.setX(position.x);
    this.fourmisGraphique.setY(position.y);
  }

  public GOval getFourmisGraphique() {
    return fourmisGraphique;
  }

  public Point getCoordonnees() {
    return coordonnees;
  }

  public void setPosition(Point coo) {
    fourmisGraphique.setX(coo.x);
    fourmisGraphique.setY(coo.y);
  }
  
  public void setColorFourmisAdulte() {
    this.fourmisGraphique.setColor(Color.red);
  }


}
