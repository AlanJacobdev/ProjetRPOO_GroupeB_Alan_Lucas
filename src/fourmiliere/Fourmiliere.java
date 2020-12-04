package fourmiliere;

import environnement.InformationsFourmiliere;
import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;



public class Fourmiliere {

  private final int rayonTerritoire = 200;
  private List<Fourmis> lesFourmis;
  private List<Fourmis> lesFourmisMortes;
  private Fourmis reine;
  private Terrain leTerrain;
  private Point positionFourmiliere;
  private GRect representationGraphique;
  private GRect representationTerritoire;
  private int stockNourriture;


  /**
   * Constructeur d'une fourmiliere.
   * 
   * @param reine La fourmis reine.
   */
  public Fourmiliere(Fourmis reine) {
    this.lesFourmis = new ArrayList<>();
    this.lesFourmisMortes = new ArrayList<>();
    this.reine = reine;
    this.leTerrain = null;
    this.positionFourmiliere = null;
    this.representationGraphique = new GRect();
    this.representationGraphique.setColor(Color.red);
    this.representationTerritoire = new GRect();
    this.representationTerritoire.setColor(Color.GREEN.darker());
    this.representationTerritoire.setBorderColor(Color.white);
    this.stockNourriture = 0;
  }

  public int getRayonTerritoire() {
    return rayonTerritoire;
  }

  public List<Fourmis> getFourmis() {
    return this.lesFourmis;
  }

  public Terrain getLeTerrain() {
    return leTerrain;
  }

  public void setLeTerrain(Terrain leTerrain) {
    this.leTerrain = leTerrain;
  }

  public Point getPositionFourmiliere() {
    return positionFourmiliere;
  }

  public void setPositionFourmiliere(Point positionFourmiliere) {
    this.positionFourmiliere = positionFourmiliere;
  }

  public List<Fourmis> getLesFourmisMortes() {
    return this.lesFourmisMortes;
  }

  public GRect getRepresentationGraphique() {
    return representationGraphique;
  }

  public void setRepresentationGraphique(GRect representationGraphique) {
    this.representationGraphique = representationGraphique;
  }

  public GRect getRepresentationTerritoire() {
    return representationTerritoire;
  }

  public void setRepresentationTerritoire(GRect representationTerritoire) {
    this.representationTerritoire = representationTerritoire;
  }
  
  /**
   * Avance d'une certaine duree le temps.
   */
  public void step() {
    for (Fourmis uneFourmis : lesFourmis) {
      uneFourmis.step();
    }
    this.reine.step();
    if (this.lesFourmisMortes.size() > 0) {
      this.removeFourmis();
    }
  }


  /**
   * Créer une portée de fourmis.
   * 
   * @param nombre : Nombre de fourmis à creer.
   */
  public void nouvellesFourmis(Integer nombre) {
    for (int i = 0; i < nombre; i++) {
      this.lesFourmis.add(new Fourmis(this));
    }
  }

  /**
   * Ajoute une fourmis mortes à la liste des fourmis mortes.
   * @param fourmis Une fourmis morte.
   */
  public void ajoutFourmisMorte(Fourmis fourmis) {
    this.lesFourmisMortes.add(fourmis);
  }

  /**
   * Retire les fourmis mortes de la listes des fourmis.
   */
  private void removeFourmis() {
    for (Fourmis fourmis : this.lesFourmisMortes) {
      this.lesFourmis.remove(fourmis);
    }
    this.lesFourmisMortes = new ArrayList<>();
  }

  /**
   * Permet de récupérer des informations sur la fourmiliere. Fait circuler le bilan des
   * informations dans aux fourmis prsentent dans la fourmilliere.
   * 
   * @param infos Bilan des informations de la fourmiliere.
   */
  public void renseignementFourmiliere(InformationsFourmiliere infos) {
    for (Fourmis f : lesFourmis) {
      f.renseignementFourmiliere(infos);
    }
  }
  
  public void ajoutNourriture() {
    this.stockNourriture++;
    System.out.println("Stock = " + this.stockNourriture);
  }

  /**
   * Affichage des informations de la fourmiliere.
   * 
   * @return Chaine de caractères contenant les informations.
   */
  public String toString() {
    StringBuffer string = new StringBuffer();
    string.append("Population : ");
    string.append(this.lesFourmis.size() + "\n");
    return string.toString();
  }


}
