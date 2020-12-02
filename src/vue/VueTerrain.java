package vue;

import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;



public class VueTerrain {

  GSpace leTerrainVue;
  GRect laFourmiliere;
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
   * @param uneFourmiliere Une fourmiliere
   */
  public void addFourmiliere(VueFourmiliere uneFourmiliere) {
    leTerrainVue.addElement(uneFourmiliere.getLaFourmiliereVue());
    Point positionFourmiliere = new Point((this.dimensionsTerrain.height / 2) - 10,
        (this.dimensionsTerrain.width / 2) - 10);
    uneFourmiliere.getLaFourmiliere().setPositionFourmiliere(positionFourmiliere);
    uneFourmiliere.getLaFourmiliereVue().translate(new Point(positionFourmiliere));
  }

  /**
   * Ajout d'une fourmis au terrain.
   * 
   * @param uneFourmis fourmis à afficher
   */
  public void addFourmis(VueFourmis uneFourmis) {
    this.leTerrainVue.addElement(uneFourmis.getFourmisGraphique());
    uneFourmis.getFourmisGraphique().setColor(Color.yellow);
  }


  public void rafraichirTerrain() {
    leTerrainVue.repaint();
  }



}
