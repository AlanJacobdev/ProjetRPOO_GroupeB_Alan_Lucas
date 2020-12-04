package fourmiliere;

import java.awt.Color;
import graphicLayer.GRect;

public class Pheromone {

  static final int taillePheromone = 5;
  protected GRect representationGraphique;
  protected int intensitePheromone;
  protected Terrain leTerrain;
  private Color couleur;
  
  public Pheromone(Terrain unTerrain) {
    this.representationGraphique = new GRect();
    this.Color = Color.cyan.darker());
    this.intensitePheromone = 0;
    this.leTerrain = unTerrain;
  }
  
  
  public void passageFourmis() {
    this.intensitePheromone = 5;
    this.representationGraphique.setColor(couleur);
    this.leTerrain.ajouterPheromone(this);
  }
  
  public void aucunPassageFourmis() {
    this.representationGraphique.
  }
  
  
  
  
  
}
