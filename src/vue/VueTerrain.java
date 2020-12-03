package vue;

import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;




public class VueTerrain {

  GSpace leTerrainVue;
  Dimension dimensionsTerrain;

  /**
   * Constructeur.
   * 
   */
  public VueTerrain(Dimension dimensionsTerrain) {
    this.dimensionsTerrain = dimensionsTerrain;
    this.leTerrainVue = new GSpace("Pelouse de Lucas", dimensionsTerrain);
    this.leTerrainVue.setColor(Color.GREEN.darker());
  }

  public void open() {
    leTerrainVue.open();
  }

  /**
   * Ajouter une fourmiliere au terrain.
   * 
   * @param fourmiliere Une fourmiliere
   */
  public void addFourmiliere(GRect fourmiliere) {
    leTerrainVue.addElement(fourmiliere);
    Point positionFourmiliere = new Point((this.dimensionsTerrain.height / 2) - 10,
        (this.dimensionsTerrain.width / 2) - 10);
    fourmiliere.setPosition(positionFourmiliere);
  }

  /**
   * Ajout d'une fourmis au terrain.
   * 
   */
  public void addFourmis(GOval fourmis) {
    this.leTerrainVue.addElement(fourmis);
  }


  public void rafraichirTerrain() {
    leTerrainVue.repaint();
  }
}
