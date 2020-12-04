package fourmiliere;

import graphicLayer.GOval;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class FourmisGraphique {

  protected final int tailleFourmis = 5;
  protected final int pas = 5;
  private Fourmis laFourmis;
  private Point coordonneesActuelle;
  private GOval representationGraphique;
  private boolean retourFourmiliere;

  /**
   * Construction de l'aspect graphique d'une fourmis adulte.
   * 
   * @param fourmis La fourmis réelle
   */
  public FourmisGraphique(Fourmis fourmis) {
    this.laFourmis = fourmis;
    this.coordonneesActuelle =
        new Point(this.getFourmis().getFourmiliere().getPositionFourmiliere().x,
            this.getFourmis().getFourmiliere().getPositionFourmiliere().y);
    this.representationGraphique = new GOval();
    this.representationGraphique.setPosition(coordonneesActuelle);
    this.representationGraphique.setDimension(new Dimension(tailleFourmis, tailleFourmis));
    this.getFourmis().getFourmiliere().getLeTerrain()
        .ajouterFourmisGraphique(representationGraphique);
    this.retourFourmiliere = false;
  }

  private Fourmis getFourmis() {
    return this.laFourmis;
  }

  public Point getCoordonneesActuelle() {
    return coordonneesActuelle;
  }

  public GOval getRepresentationGraphique() {
    return this.representationGraphique;
  }

  /**
   * Savoir si la fourmis se situe dans la fourmiliere ou non.
   * 
   * @return <b>true</b> si la fourmis se situe dans la fourmiliere sinon <b>false</b>
   */
  private Boolean dansFourmiliere() {
    if (this.coordonneesActuelle.x > this.getFourmis().getFourmiliere().getPositionFourmiliere().x
        - 5
        && this.coordonneesActuelle.x < this.getFourmis().getFourmiliere()
            .getPositionFourmiliere().x + 20
        && this.coordonneesActuelle.y > this.getFourmis().getFourmiliere()
            .getPositionFourmiliere().y - 5
        && this.coordonneesActuelle.y < this.getFourmis().getFourmiliere()
            .getPositionFourmiliere().y + 20) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Savoir si la fourmis se situe dans le terrain ou non.
   * 
   * @return <b>true</b> si la fourmis se situe dans le territoire sinon <b>false</b>
   */
  private Boolean dansTerritoire() {
    if (coordonneesActuelle.x <= this.getFourmis().getFourmiliere().getPositionFourmiliere().x
        + this.getFourmis().getFourmiliere().getRayonTerritoire()
        && coordonneesActuelle.x >= this.getFourmis().getFourmiliere().getPositionFourmiliere().x
            - this.getFourmis().getFourmiliere().getRayonTerritoire()
        && coordonneesActuelle.y <= this.getFourmis().getFourmiliere().getPositionFourmiliere().y
            + this.getFourmis().getFourmiliere().getRayonTerritoire()
        && coordonneesActuelle.y >= this.getFourmis().getFourmiliere().getPositionFourmiliere().y
            - this.getFourmis().getFourmiliere().getRayonTerritoire()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Déplacement aléatoire de la fourmis au sein de son territoire.
   */
  public void prochainePosition() {
    if (!(this.retourFourmiliere)) {
      if (this.coordonneesActuelle != null) {
        int deplacement =
            (int) (Math.random() * (Adulte.maximalPopulation - Adulte.minimumPopulation));
        if (this.dansTerritoire()) {
          if (deplacement <= 25) {
            this.coordonneesActuelle = prochainPoint(this.pas, 0);
            this.representationGraphique.setPosition(coordonneesActuelle);
          } else if (deplacement <= 50) {
            this.coordonneesActuelle = prochainPoint(this.pas, 1);
            this.representationGraphique.setPosition(coordonneesActuelle);
          } else if (deplacement <= 75) {
            this.coordonneesActuelle = prochainPoint(this.pas, 2);
            this.representationGraphique.setPosition(coordonneesActuelle);
          } else if (deplacement <= 100) {
            this.coordonneesActuelle = prochainPoint(this.pas, 3);
            this.representationGraphique.setPosition(coordonneesActuelle);
          }
          if (this.dansFourmiliere()) {
            this.representationGraphique.setColor(Color.red);
          } else {
            this.representationGraphique.setColor(Color.blue);
          }

          this.manger();

        }
      }
    } else {
      if (this.dansFourmiliere()) {
        this.laFourmis.getFourmiliere().ajoutNourriture();
        this.retourFourmiliere = false;
        this.representationGraphique.setColor(Color.blue);
      } else {
        this.representationGraphique.setColor(Color.MAGENTA);
        Fourmiliere laFourmiliere = this.laFourmis.getFourmiliere();
        int trajetX = this.coordonneesActuelle.x - laFourmiliere.getPositionFourmiliere().x;
        int trajetY = this.coordonneesActuelle.y - laFourmiliere.getPositionFourmiliere().y;
        if (trajetX == 0) {
          int direction = this.definitionDirection(trajetY);
          this.coordonneesActuelle =
              new Point(this.coordonneesActuelle.x, this.coordonneesActuelle.y + direction);
          this.representationGraphique.setPosition(this.coordonneesActuelle);
        } else if (trajetY == 0) {
          int direction = this.definitionDirection(trajetX);
          this.coordonneesActuelle =
              new Point(this.coordonneesActuelle.x  + direction, this.coordonneesActuelle.y);
          this.representationGraphique.setPosition(this.coordonneesActuelle);
        } else if (trajetX <= trajetY) {
          int direction = this.definitionDirection(trajetX);
          this.coordonneesActuelle =
              new Point(this.coordonneesActuelle.x  + direction, this.coordonneesActuelle.y);
          this.representationGraphique.setPosition(this.coordonneesActuelle);
        } else if (trajetY < trajetX) {
          int direction = this.definitionDirection(trajetY);
          this.coordonneesActuelle =
              new Point(this.coordonneesActuelle.x, this.coordonneesActuelle.y  + direction);
          this.representationGraphique.setPosition(this.coordonneesActuelle);
        }
      }
    }
  }

  private int definitionDirection(int val) {
    if (val > 0) {
      return -1;
    } else {
      return 1;
    }
  }

  /**
   * Permet de calculer ou se trouve la fourmis à l'instant T.
   * 
   * @param pas Distance entre 2 position lors d'un pas en avant dans le temps.
   * @param direction Direction dans laquelle la fourmis se dirige
   * @return La nouvelle position
   */
  public Point prochainPoint(int pas, int direction) {
    switch (direction) {
      case 0:
        if (this.coordonneesActuelle.y
            + pas > this.laFourmis.getFourmiliere().getPositionFourmiliere().y
                + this.laFourmis.getFourmiliere().getRayonTerritoire()) {
          return new Point(this.coordonneesActuelle.x, 450);
        } else {
          return new Point(this.coordonneesActuelle.x, this.coordonneesActuelle.y + pas);
        }
      case 1:
        if (this.coordonneesActuelle.y
            - pas < this.laFourmis.getFourmiliere().getPositionFourmiliere().y
                - this.laFourmis.getFourmiliere().getRayonTerritoire()) {
          return new Point(this.coordonneesActuelle.x, 50);
        } else {
          return new Point(this.coordonneesActuelle.x, this.coordonneesActuelle.y - pas);
        }
      case 2:
        if (this.coordonneesActuelle.x
            + pas > this.laFourmis.getFourmiliere().getPositionFourmiliere().x
                + this.laFourmis.getFourmiliere().getRayonTerritoire()) {
          return new Point(450, this.coordonneesActuelle.y);
        } else {
          return new Point(this.coordonneesActuelle.x + pas, this.coordonneesActuelle.y);
        }
      case 3:
        if (this.coordonneesActuelle.x
            - pas < this.laFourmis.getFourmiliere().getPositionFourmiliere().x
                - this.laFourmis.getFourmiliere().getRayonTerritoire()) {
          return new Point(50, this.coordonneesActuelle.y);
        } else {
          return new Point(this.coordonneesActuelle.x - pas, this.coordonneesActuelle.y);
        }
      default:
        return null;
    }
  }

  /**
   * Mort de la fourmis.
   */
  public void mort() {
    if (this.dansTerritoire()) {
      this.representationGraphique.setColor(Color.yellow);
    }
  }

  private void manger() {
    Proie laProie = this.laFourmis.getFourmiliere().getLeTerrain().attaqueUneProie(this.coordonneesActuelle);
    if (laProie != null) {
      this.retourFourmiliere = true;
      this.laFourmis.getFourmiliere().getLeTerrain().supprimerProie(laProie);
    }
  }
}
