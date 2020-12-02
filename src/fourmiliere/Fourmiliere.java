package fourmiliere;

import environnement.InformationsFourmiliere;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Fourmiliere {

  private List<Fourmis> lesFourmis;
  private List<Fourmis> lesFourmisMortes;
  private Fourmis reine;
  private InformationsFourmiliere infos;
  private Terrain leTerrain;
  private Point positionFourmiliere;
  
  

  /**
   * Constructeur d'une fourmilière.
   * 
   * @param reine La fourmis reine.
   */
  public Fourmiliere(Fourmis reine) {
    this.lesFourmis = new ArrayList<>();
    this.lesFourmisMortes = new ArrayList<>();
    this.reine = reine;
    this.leTerrain = null;
    this.positionFourmiliere = null;
  }

  /**
   * .
   */
  public void step() {
    this.infos = leTerrain.getInfos();
    for (Fourmis uneFourmis : lesFourmis) {
      uneFourmis.getRole().renseignerInformations();
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
   * @param nombre : Nombre de fourmis à créer.
   */
  public void nouvellesFourmis(Integer nombre) {
    for (int i = 0; i < nombre; i++) {
      this.lesFourmis.add(new Fourmis(this));
    }
  }

  public InformationsFourmiliere getInfos() {
    return this.infos;
  }
  
  public void ajoutFourmisMorte(Fourmis fourmis) {
    this.lesFourmisMortes.add(fourmis);
  }

  private void removeFourmis() {
    for (Fourmis fourmis : this.lesFourmisMortes) {
      this.lesFourmis.remove(fourmis);
    }
    this.lesFourmisMortes = new ArrayList<>();
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

  /**
   * Affichage des informations de la fourmilière.
   * 
   * @return Chaine de caractères contenant les informations.
   */
  public String toString() {
    StringBuffer string = new StringBuffer();
    string.append("Population : ");
    string.append(this.lesFourmis.size() + "\n");
    string.append(this.leTerrain.getInfos().toString());
    return string.toString();
  }
}
