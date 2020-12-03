package vue;

import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;
import java.awt.Color;
import java.awt.Dimension;



public class VueTerrain {

  GSpace leTerrainVue;
  Dimension dimensionsTerrain;

  /**
   * Constructeur d'un terrain graphique. 
   * 
   * @param dimensionsTerrain Les dimension du terrain graphique
   */
  public VueTerrain(Dimension dimensionsTerrain) {
    this.dimensionsTerrain = dimensionsTerrain;
    this.leTerrainVue = new GSpace("Pelouse de Lucas", dimensionsTerrain);
    this.leTerrainVue.setColor(Color.GREEN.darker().darker());
  }

  /**
   * Afficher le terrain.
   */
  public void open() {
    leTerrainVue.open();
  }

  /**
   * Ajouter une fourmiliere au terrain.
   * 
   * @param fourmiliere Une fourmiliere
   * @param territoire Le territoire
   */
  public void addFourmiliere(GRect territoire, GRect fourmiliere) {
    leTerrainVue.addElement(territoire);
    leTerrainVue.addElement(fourmiliere);
  }

  /**
   * Ajouter une proie au terrain.
   * @param proie la Proie
   */
  public void addProie(GRect proie) {
    leTerrainVue.addElement(proie);
  }
  
  /**
   * Suppresion d'une proie sur le terrain.
   * @param proie la proie a supprimer
   */
  public void delProie(GRect proie) {
    leTerrainVue.removeElement(proie);
  }


  /**
   * Ajout d'une fourmis au terrain.
   * @param fourmis la fourmis a ajouter
   */
  public void addFourmis(GOval fourmis) {
    this.leTerrainVue.addElement(fourmis);
  }
  
  /**
   * Permet la suppression de fourmis sur le terrain.
   * @param fourmis la fourmis a supprimer
   */
  public void delFourmis(GOval fourmis) {
    this.leTerrainVue.removeElement(fourmis);
  }

  /**
   * Permet de rafraichir le terrain.
   */
  public void rafraichirTerrain() {
    leTerrainVue.repaint();
  }



}
