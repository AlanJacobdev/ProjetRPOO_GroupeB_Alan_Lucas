package fourmiliere;

import graphicLayer.GRect;
import java.awt.Color;
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
    this.couleur = Color.cyan.darker();
    this.intensitePheromone = 0;
    this.leTerrain = unTerrain;
    this.coordonees = unePosition;
  }

  /**
   * Réagis au passage de la fourmi et s'affiche.
   */
  public void passageFourmis() {
    if (this.intensitePheromone > 0) {
      this.representationGraphique.setColor(couleur.darker());
    } else {
      this.representationGraphique.setColor(couleur);
      this.leTerrain.ajouterPheromone(this.representationGraphique);
    }

    this.intensitePheromone = 5;
  }

  /**
   * Si aucune passe sur la position de la phéromone, alors celle-ci se détériore.
   */
  public void aucunPassageFourmis() {
    this.couleur = couleur.darker();
    --this.intensitePheromone;
    if (this.intensitePheromone == 0) {
      this.leTerrain.supprimerPheromone(this.representationGraphique);
    }
  }


  /**
   * Avancé dans le temps.
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
