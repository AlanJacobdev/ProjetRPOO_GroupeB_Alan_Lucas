package fourmiliere;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class Pheromone {

  static final int taillePheromone = 5;
  protected GRect representationGraphique;
  protected int intensitePheromone;
  protected Terrain leTerrain;
  protected Color couleur;
  protected Point coordonees;



  /**
   * Constructeur des pheromone.
   * 
   * @param unTerrain Le terrain ou se situe les phéromones.
   */
  public Pheromone(Terrain unTerrain, Point unePosition) {
    this.representationGraphique = new GRect();
    this.couleur = Color.GREEN.darker();
    this.intensitePheromone = 0;
    this.leTerrain = unTerrain;
    this.coordonees = unePosition;
    this.representationGraphique.setColor(couleur);
    this.representationGraphique.setBorderColor(couleur);
    this.leTerrain.ajouterPheromone(this.representationGraphique);
    System.out.println(this.coordonees);
    this.representationGraphique.setPosition(this.coordonees);
    this.representationGraphique.setDimension(new Dimension(taillePheromone, taillePheromone));
  }

  /**
   * Réagis au passage de la fourmi et s'affiche.
   */
  public void passageFourmis() {
    if (this.intensitePheromone == 0) {
      this.representationGraphique.setColor(couleur);
    }
    this.intensitePheromone = 400;
  }

  /**
   * Si aucune passe sur la position de la phéromone, alors celle-ci se détériore.
   */
  public void aucunPassageFourmis() {
    this.intensitePheromone--;
    if (this.intensitePheromone > 0) {
      this.couleur = couleur.brighter();
      this.representationGraphique.setColor(couleur);
      this.representationGraphique.setBorderColor(couleur);
    } else if (this.intensitePheromone <= 0) {
      this.couleur = Color.GREEN.darker();
      this.representationGraphique.setColor(couleur);
      this.representationGraphique.setBorderColor(couleur);
    }
  }

  /**
   * Avancé dans le temps.
   * 
   * @param presenceFourmi Une fourmi est passé sur la case correspondant à la phéromone.
   */
  public void step(Boolean presenceFourmi) {
    if (presenceFourmi) {
      this.passageFourmis();
    } else {
      this.aucunPassageFourmis();
    }
  }


}
