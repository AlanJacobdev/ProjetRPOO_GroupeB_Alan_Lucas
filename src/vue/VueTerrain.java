package vue;

import fourmiliere.Terrain;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Point;



public class VueTerrain {

  Terrain leTerrain;
  GSpace leTerrainVue;
  GRect laFourmiliere;

  /**
   * Constructeur.
   * 
   * @param unTerrain Le terrain associé à la vue.
   */
  public VueTerrain(Terrain unTerrain) {
    this.leTerrain = unTerrain;
    this.leTerrainVue = new GSpace("Pelouse de Lucas", this.leTerrain.getTailleTerrain());
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
    Point positionFourmiliere = new Point(this.leTerrain.getTailleTerrain().height / 2,
        this.leTerrain.getTailleTerrain().width / 2);
    uneFourmiliere.getLaFourmiliere().setPositionFourmiliere(positionFourmiliere);
    uneFourmiliere.getLaFourmiliereVue().translate(new Point(positionFourmiliere));
    leTerrainVue.repaint();
  }



}
