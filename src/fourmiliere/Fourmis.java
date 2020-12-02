package fourmiliere;

import environnement.InformationsFourmiliere;
import java.awt.Point;
import vue.VueFourmis;



public class Fourmis {

  Etape etape;
  Fourmiliere saFourmiliere;
  VueFourmis representationGraphique;
  Point coordonneesActuelle;
  Boolean isAdult;

  /**
   * Constructeur d'une fourmis.
   * 
   * @param fourmiliere La fourmilière a laquelle elle est liée
   */
  public Fourmis(Fourmiliere fourmiliere) {
    this.saFourmiliere = fourmiliere;
    this.etape = new Oeuf(this);
    this.isAdult = false;
    if (fourmiliere != null) {
      this.coordonneesActuelle = new Point(fourmiliere.getPositionFourmiliere().x + 5,
          fourmiliere.getPositionFourmiliere().y + 5);
      this.representationGraphique = new VueFourmis(this.coordonneesActuelle);
      this.saFourmiliere.getLeTerrain().ajouterFourmisGraphique(this);
    }
  }

  public Role getRole() {
    return this.etape.next().getRole();
  }

  public Fourmiliere getFourmiliere() {
    return this.saFourmiliere;
  }

  public void setFourmilliere(Fourmiliere uneFourmilliere) {
    this.saFourmiliere = uneFourmilliere;
  }

  public Etape getEtape() {
    return this.etape;
  }

  /**
   * Création d'un reine.
   * 
   * @return un Objet Fourmis dont l'étape est de type Adulte et le role est de type Reine.
   */
  public Fourmis creerReine() {
    Adulte reine = new Adulte(this);
    reine.attributionRoleReine();
    this.etape = reine;

    return this;
  }

  /** . */
  public void step() {
    this.etape = etape.next();
    etape.step();
    if (this.getRole() != null && !(this.getRole() instanceof Reine)) {
      if (!(this.isAdult)) {
        isAdult = true;
        this.representationGraphique.setColorFourmisAdulte();
      }
      representationGraphique.setPosition(prochainePosition());
    }
  }

  public void renseignementFourmiliere(InformationsFourmiliere infos) {
    this.getEtape().renseignerInformations(infos);
  }

  /**
   * Déplacement aléatoire de la fourmis.
   * 
   * @return la coordonnée
   */
  public Point prochainePosition() {
    int deplacement = (int) (Math.random() * (0 - 100));
    if (!(coordonneesActuelle.x > saFourmiliere.getPositionFourmiliere().x + 200
        || coordonneesActuelle.y > saFourmiliere.getPositionFourmiliere().y + 200)) {
      if (deplacement <= 25) {
        this.representationGraphique
        .setPosition(new Point(coordonneesActuelle.x, coordonneesActuelle.y + 1));
      }
      if (deplacement <= 50) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x, coordonneesActuelle.y - 1));
      }
      if (deplacement <= 75) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x + 1, coordonneesActuelle.y));
      }
      if (deplacement <= 100) {
        this.representationGraphique
            .setPosition(new Point(coordonneesActuelle.x - 1, coordonneesActuelle.y));
      }
    }
    return coordonneesActuelle;
  }


}
