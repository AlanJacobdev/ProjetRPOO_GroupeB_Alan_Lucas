package fourmiliere;

import environnement.InformationsFourmiliere;
import environnement.Saison;
import graphicLayer.GOval;
import graphicLayer.GRect;
import vue.VueTerrain;
import java.awt.Dimension;


public class Terrain {

  private Saison lesSaisons;
  private Dimension tailleTerrain;
  private Fourmiliere laFourmiliere;
  private InformationsFourmiliere infos;
  private VueTerrain leTerrain;

  /**
   * Constructeur.
   */
  public Terrain() {
    this.lesSaisons = new Saison();
    this.tailleTerrain = new Dimension(400, 400);
    this.leTerrain = new VueTerrain(tailleTerrain);
  }

  public void afficherTerrain() {
    leTerrain.open();
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  public void setLaFourmiliere(Fourmiliere laFourmiliere) {
    this.laFourmiliere = laFourmiliere;
  }


  public Saison getLesSaisons() {
    return lesSaisons;
  }

  public void setLesSaisons(Saison lesSaisons) {
    this.lesSaisons = lesSaisons;
  }

  public Dimension getTailleTerrain() {
    return tailleTerrain;
  }

  public void setTailleTerrain(Dimension tailleTerrain) {
    this.tailleTerrain = tailleTerrain;
  }

  public InformationsFourmiliere getInfos() {
    return infos;
  }

  public void setInfos(InformationsFourmiliere infos) {
    this.infos = infos;
  }

  public VueTerrain getLeTerrain() {
    return leTerrain;
  }

  public void ajouterFourmiliereGraphique(GRect representationGraphique) {
    this.getLeTerrain().addFourmiliere(representationGraphique);
  }

  public void ajouterFourmisGraphique(GOval fourmis) {
    this.getLeTerrain().addFourmis(fourmis);
  }

  /**
   * .
   */
  public void step() {
    this.laFourmiliere.step();
  }

  public void renseignementFourmiliere() {
    this.infos = new InformationsFourmiliere();
    this.laFourmiliere.renseignementFourmiliere(infos);
  }

  @Override
  public String toString() {
    String s = laFourmiliere.toString() + infos.toString();
    return s;
  }

  public void open() {
    this.leTerrain.open();

  }

  public void rafraichirIhm() {
    this.leTerrain.rafraichirTerrain();
  }

}
