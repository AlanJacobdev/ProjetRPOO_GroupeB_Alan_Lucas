package fourmiliere;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Proie {
  private Point position;
  private Dimension taille;
  private Color couleur;
  
  public Proie() {
    int x = (int) (Math.random() * (500 - 0));
    int y = (int) (Math.random() * (500 - 0));
    this.position = new Point(x, y);
    this.taille = new Dimension(10, 10);
    this.couleur = Color.ORANGE;
  }

  public Point getPosition() {
    return position;
  }

  public Dimension getTaille() {
    return taille;
  }

  public Color getCouleur() {
    return couleur;
  }
}
