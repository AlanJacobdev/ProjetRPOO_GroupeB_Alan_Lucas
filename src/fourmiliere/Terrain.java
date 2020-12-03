package fourmiliere;

import environnement.InformationsFourmiliere;
import environnement.Saison;
import graphicLayer.GOval;
import graphicLayer.GRect;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import vue.VueTerrain;

public class Terrain {

  protected final int coteTerrain = 500;
  protected Saison lesSaisons;
  protected Dimension tailleTerrain;
  protected Fourmiliere laFourmiliere;
  protected InformationsFourmiliere infos;
  protected VueTerrain leTerrain;
  protected List<Proie> lesProies;
  protected List<Proie> lesProiesMortes;

  /**
   * Constructeur d'un terrain.
   */
  public Terrain() {
    this.lesSaisons = new Saison();
    this.tailleTerrain = new Dimension(coteTerrain, coteTerrain);
    this.leTerrain = new VueTerrain(tailleTerrain);
    this.lesProies = new ArrayList<Proie>();
    this.lesProiesMortes = new ArrayList<Proie>();
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

  /**
   * Afficher la vue graphique du terrain.
   */
  public void afficherTerrain() {
    leTerrain.open();
  }

  /**
   * Ajout d'une fourilière au centre du terain.
   * 
   * @param representationGraphique representation graphique de la fourmiliere
   * @param representationTerritoire representation graphique du territoire de la fourmiliere
   */
  public void ajouterFourmiliereGraphique(GRect representationGraphique,
      GRect representationTerritoire) {
    Point coordoneesFourmiliere =
        new Point(this.tailleTerrain.height / 2, this.tailleTerrain.width / 2);
    this.laFourmiliere.setPositionFourmiliere(coordoneesFourmiliere);
    Point coordoneesTerritoire =
        new Point(coordoneesFourmiliere.x - 190, coordoneesFourmiliere.y - 190);
    this.laFourmiliere.getRepresentationTerritoire().setPosition(coordoneesTerritoire);
    this.laFourmiliere.getRepresentationTerritoire().setDimension(new Dimension(400, 400));
    this.laFourmiliere.getRepresentationGraphique().setPosition(coordoneesFourmiliere);
    this.getLeTerrain().addFourmiliere(representationTerritoire, representationGraphique);
  }

  /**
   * Ajouter une fourmis au terrain graphique.
   * 
   * @param fourmis Une fourmis grapique (GOval)
   */
  public void ajouterFourmisGraphique(GOval fourmis) {
    this.getLeTerrain().addFourmis(fourmis);
  }

  /**
   * Supprimer une fourmis au terrain graphique.
   * 
   * @param fourmis Une fourmis graphique (GOval)
   */
  public void supprimerFourmisGraphique(GOval fourmis) {
    this.getLeTerrain().delFourmis(fourmis);
  }

  /**
   * Ajouter une proie au terrain graphique.
   */
  private void ajouterProie() {
    Proie proie = new Proie(this);
    this.lesProies.add(proie);
    this.leTerrain.addProie(proie.getRepresentationGraphique());
  }

  /**
   * Supprimer une proie du terrain graphique.
   * 
   * @param proie La Proie a supprimer
   */
  public void supprimerProie(Proie proie) {
    this.lesProiesMortes.add(proie);
  }

  /**
   * Avance d'une certaine durée le temps.
   */
  public void step() {
    this.laFourmiliere.step();
    int tirage = (int) (Math.random() * (10 - 0));
    if (tirage == 1) {
      if (this.lesProies.size() < this.laFourmiliere.getFourmis().size() * 0.05) {
        this.ajouterProie();
      }
    }
    this.deplacementProies();
    if (this.lesProiesMortes.size() > 0) {
      for (Proie proie : this.lesProiesMortes) {
        this.leTerrain.delProie(proie.getRepresentationGraphique());
        this.lesProies.remove(proie);
      }
    }
    this.leTerrain.rafraichirTerrain();
  }

  /**
   * Permet de récupérer des informations sur la fourmiliere. Fait circuler le bilan des
   * informations dans aux fourmis presentent dans la fourmilliere.
   */
  public void renseignementFourmiliere() {
    this.infos = new InformationsFourmiliere();
    this.laFourmiliere.renseignementFourmiliere(infos);
  }
  
  /**
   * Affiche le terrain graphique.
   */
  public void open() {
    this.leTerrain.open();
  }

  /**
   * Deplacement des proies.
   */
  public void deplacementProies() {
    for (Proie p : lesProies) {
      p.prochainePosition();
    }
  }

  /**
   * Rafraichit l'affichage du terrain graphique.
   */
  public void rafraichirIhm() {
    this.leTerrain.rafraichirTerrain();
  }

  
  /**
   * Afiiche les informations relatives à la fourmilière.
   */
  @Override
  public String toString() {
    String s = laFourmiliere.toString() + infos.toString();
    return s;
  }

}
