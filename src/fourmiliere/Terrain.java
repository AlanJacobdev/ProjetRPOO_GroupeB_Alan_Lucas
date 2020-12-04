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
  protected final int tailleTerritoireFourmiliere = 400;
  protected Saison lesSaisons;
  protected Dimension tailleTerrain;
  protected Fourmiliere laFourmiliere;
  protected InformationsFourmiliere infos;
  protected VueTerrain leTerrain;
  protected List<Proie> lesProies;
  protected List<Proie> lesProiesMortes;
  protected Pheromone[][] lesPheromones;

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
   * Récupérer un phéromone.
   * 
   * @param x coordonnées en x
   * @param y coordonées en y
   * @return <b>true</b> si le phéromone existe sinon <b>false</b>
   */
  public Pheromone getUnPheromone(int x, int y) {
    int xpos = (x - 55) / 5;
    int ypos = (y - 55) / 5;
    Pheromone unPheromone = this.lesPheromones[xpos][ypos];
    if (unPheromone != null) {
      return unPheromone;
    }
    return null;
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
        new Point(coordoneesFourmiliere.x - 191, coordoneesFourmiliere.y - 191);
    this.laFourmiliere.getRepresentationTerritoire().setPosition(coordoneesTerritoire);
    this.laFourmiliere.getRepresentationTerritoire().setDimension(
        new Dimension(tailleTerritoireFourmiliere + 2, tailleTerritoireFourmiliere + 2));
    this.laFourmiliere.getRepresentationGraphique().setPosition(coordoneesFourmiliere);
    this.getLeTerrain().addTerritoire(representationTerritoire);
    this.preconfigurerPheromone();
    this.getLeTerrain().addFourmiliere(representationGraphique);
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
   * Mettre en place le tableau des phéromones.
   */
  public void preconfigurerPheromone() {
    this.lesPheromones = new Pheromone[this.tailleTerritoireFourmiliere / 5
        + 1][this.tailleTerritoireFourmiliere / 5 + 1];
    for (int i = 1; i < lesPheromones.length; i++) {
      for (int j = 1; j < lesPheromones[i].length; j++) {
        lesPheromones[i][j] = new Pheromone(this, new Point(55 + i * 5, 55 + j * 5));
        System.out.println(55 + i * 5);
      }
    }
  }

  public void ajouterPheromone(GRect representationGraphique) {
    this.leTerrain.addPheromone(representationGraphique);
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
   * Avance d'une certaine duree le temps.
   */
  public void step() {
    this.laFourmiliere.step();

    int tirage = (int) (Math.random() * (10 - 0));
    if (tirage == 1) {
      if (this.lesProies.size() < this.laFourmiliere.getFourmis().size() * 0.5) {
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
    verificationPheromones();
    this.leTerrain.rafraichirTerrain();
  }

  /**
   * Permet de recuperer des informations sur la fourmiliere. Fait circuler le bilan des
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
      if (!(p.isMort())) {
        p.prochainePosition();
      }
    }
  }

  /**
   * Rafraichit l'affichage du terrain graphique.
   */
  public void rafraichirIhm() {
    this.leTerrain.rafraichirTerrain();
  }

  /**
   * Vérifie la présence d'une fourmi sur la case x y.
   */
  public void verificationPheromones() {
    List<Fourmis> lesfourmis = this.getLaFourmiliere().getFourmis();
    for (int i = 1; i < lesPheromones.length; i++) {
      for (int j = 1; j < lesPheromones[i].length; j++) {
        for (int k = 0; k < lesfourmis.size(); k++) {
          Fourmis uneFourmis = lesfourmis.get(k);
          Pheromone unPheromone = lesPheromones[i][j];
          if (uneFourmis.getEtape() instanceof Adulte) {
            if (((Adulte) uneFourmis.getEtape()).getRepresentationGraphique()
                .getCoordonneesActuelle().x == unPheromone.coordonees.x
                && ((Adulte) uneFourmis.getEtape()).getRepresentationGraphique()
                    .getCoordonneesActuelle().y == unPheromone.coordonees.y) {
              lesPheromones[i][j].step(true);
            } else {
              lesPheromones[i][j].step(false);
            }
          }
        }
      }
    }
  }
  
  /**
   * Teste si une fourmis se trouve au meme endrois qu'une proie, alors elle tue la proie.
   * @param coordonneeFourmis La position de la fourmis.
   */
  public Proie attaqueUneProie(Point coordonneeFourmis) {
    for (Proie proie : this.lesProies) {
      if ((proie.getPositionActuelle().getX() < coordonneeFourmis.getX() + 5 
            && proie.getPositionActuelle().getY() > coordonneeFourmis.getY() - 5) 
          && (proie.getPositionActuelle().getX() > coordonneeFourmis.getX() - 5 
              && proie.getPositionActuelle().getY() < coordonneeFourmis.getY() + 5)) {
        proie.morte();
        return proie;
      }
    }
    return null;
  }

  /**
   * Affiche les informations relatives à la fourmiliere.
   */
  @Override
  public String toString() {
    String s = laFourmiliere.toString() + infos.toString();
    return s;
  }

}
