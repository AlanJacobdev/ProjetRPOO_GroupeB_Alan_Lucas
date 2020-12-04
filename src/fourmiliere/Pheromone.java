package fourmiliere;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class Pheromone {
  protected final Color couleurTerrain = Color.GREEN.darker();
  protected final Color couleurPheromone = Color.gray;
  protected final int taillePheromone = 5;
  protected final int miseAJourPheromone = 5;
  protected Color decrementationCouleur;
  protected GRect representationGraphique;
  protected int intensitePheromone;
  protected Terrain leTerrain;
  protected Color couleur;
  protected Point coordonees;
  protected int nombreDePas;



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
    this.representationGraphique.setPosition(this.coordonees);
    this.representationGraphique.setDimension(new Dimension(taillePheromone, taillePheromone));
    this.decrementationCouleur = couleurPheromone;
    this.nombreDePas = 0;
  }

  
  public int getIntensitePheromone() {
    return intensitePheromone;
  }

  /**
   * Réagis au passage de la fourmi et s'affiche.
   */
  public void passageFourmis() {
    if (this.intensitePheromone == 0) {
      this.representationGraphique.setColor(couleurPheromone);
      this.representationGraphique.setBorderColor(couleurPheromone);
      this.intensitePheromone = 100;
    } else {
      this.intensitePheromone = 100;
      this.representationGraphique.setColor(couleurPheromone);
      this.representationGraphique.setBorderColor(couleurPheromone);
    }
  }

  /**
   * Si aucune passe sur la position de la phéromone, alors celle-ci se détériore.
   */
  public void aucunPassageFourmis() {
    if (nombreDePas % miseAJourPheromone == 0) {
      this.intensitePheromone--;
      if (this.intensitePheromone <= 0) {
        this.intensitePheromone = 0;
        this.representationGraphique.setColor(couleurTerrain);
        this.representationGraphique.setBorderColor(couleurTerrain);
      } else if (this.intensitePheromone <= 10) {
        this.decrementationCouleur = Color.LIGHT_GRAY;
        this.representationGraphique.setColor(decrementationCouleur);
        this.representationGraphique.setBorderColor(decrementationCouleur);
      }
    }


  }

  /**
   * Avancé dans le temps.
   * 
   * @param presenceFourmi Une fourmi est passé sur la case correspondant à la phéromone.
   */
  public void step(Boolean presenceFourmi) {
    ++nombreDePas;
    if (presenceFourmi) {
      this.passageFourmis();
    } else {
      this.aucunPassageFourmis();
    }
  }


}
