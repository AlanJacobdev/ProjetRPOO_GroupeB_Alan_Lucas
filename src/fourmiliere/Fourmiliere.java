package fourmiliere;

import environnement.InformationsFourmiliere;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Fourmiliere {

  private List<Fourmis> lesFourmis;
  private List<Fourmis> lesFourmisMortes;
  private Fourmis reine;
  private Terrain leTerrain;
  private Point positionFourmiliere;



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
  }

  /**
   * Avance d'une certaine durée le temps.
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
   * Créer une portee de fourmis.
   *
   * @param nombre : Nombre de fourmis à creer.
   */
  public void nouvellesFourmis(Integer nombre) {
    for (int i = 0; i < nombre; i++) {
      this.lesFourmis.add(new Fourmis(this));
    }
  }

  /**
  * Ajoute une fourmis a la liste des fourmis mortes.
  * @parem fourmis Une fourmis morte.
  */
  public void ajoutFourmisMorte(Fourmis fourmis) {
    this.lesFourmisMortes.add(fourmis);
  }

  /**
  * Retire les fourmis mortes de la liste des fourmis.
  */
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

  public List<Fourmis> getLesFourmisMortes() {
    return this.lesFourmisMortes;
  }

  /**
   * Appelle la mise à jours des informations de chaques fourmis dans les informations de la
   * fourmiliere.
   *
   * @param infos Information de la fourmiliere.
   */
  public void renseignementFourmiliere(InformationsFourmiliere infos) {
    for (Fourmis f : lesFourmis) {
      f.renseignementFourmiliere(infos);
    }
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
    return string.toString();
  }


}
