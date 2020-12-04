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
   */
  public void addFourmiliere(GRect fourmiliere) {

    leTerrainVue.addElement(fourmiliere);
  }

  /**
   * Ajouter du territoire d'une fouriliere au terrain.
   * 
   * @param territoire Le territoire
   */
  public void addTerritoire(GRect territoire) {
    leTerrainVue.addElement(territoire);
  }

  /**
   * Ajouter une proie au terrain.
   * 
   * @param proie la Proie
   */
  public void addProie(GRect proie) {
    leTerrainVue.addElement(proie);
  }

  /**
   * Suppresion d'une proie sur le terrain.
   * 
   * @param proie la proie a supprimer
   */
  public void delProie(GRect proie) {
    leTerrainVue.removeElement(proie);
  }

  /**
   * Ajout d'une fourmis au terrain.
   * 
   * @param fourmis la fourmis a ajouter
   */
  public void addFourmis(GOval fourmis) {
    this.leTerrainVue.addElement(fourmis);
  }

  /**
   * Permet la suppression de fourmis sur le terrain.
   * 
   * @param fourmis la fourmis a supprimer
   */
  public void delFourmis(GOval fourmis) {
    this.leTerrainVue.removeElement(fourmis);
  }

  /**
   * Ajout d'un pheromone au terrain.
   * 
   * @param pheromone le pheromone a ajouter
   */
  public void addPheromone(GRect pheromone) {
    this.leTerrainVue.addElement(pheromone);
  }

  /**
   * Permet de rafraichir le terrain.
   */
  public void rafraichirTerrain() {
    leTerrainVue.repaint();
  }



}
