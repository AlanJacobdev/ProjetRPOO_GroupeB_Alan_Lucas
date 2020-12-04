package fourmiliere;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;


public class Proie {
  protected Terrain terrain;
  protected Point positionActuelle;
  protected GRect representationGraphique;
  
  protected boolean mort;

  /**
   * Constructeur d'une proie.
   * 
   * @param terrain Terrain sur lequel la proie évolue
   */
  public Proie(Terrain terrain) {
    this.terrain = terrain;
    int x = (int) (Math.random() * (terrain.getTailleTerrain().height - 0));
    int y = (int) (Math.random() * (terrain.getTailleTerrain().width - 0));
    this.positionActuelle = new Point(x, y);
    this.representationGraphique = new GRect();
    this.representationGraphique.setColor(Color.WHITE);
    this.representationGraphique.setDimension(new Dimension(5, 5));
    this.representationGraphique.setPosition(positionActuelle);
    this.representationGraphique.setBorderColor(Color.WHITE.darker());
    
    this.mort = false;
  }

  public Point getPositionActuelle() {
    return positionActuelle;
  }

  public void setPositionActuelle(Point positionActuelle) {
    this.positionActuelle = positionActuelle;
  }

  public GRect getRepresentationGraphique() {
    return representationGraphique;
  }

  public void setRepresentationGraphique(GRect representationGraphique) {
    this.representationGraphique = representationGraphique;
  }

  /**
   * Savoir si la proie est dans le terrain ou non.
   * @return <b>true</b> si la proie se situe dans le terrain sinon <b>false</b>
   */
  public Boolean dansTerrain() {
    if (positionActuelle.x < this.terrain.getTailleTerrain().width && positionActuelle.x > 0
        && positionActuelle.y < this.terrain.getTailleTerrain().height && positionActuelle.x > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Déplacement aléatoire d'une proie, suprresion si elle sort du terrain visible.
   */
  public void prochainePosition() {
    int deplacement = (int) (Math.random() * (100 - 0));
    if (this.dansTerrain()) {
      if (deplacement <= 25) {
        this.positionActuelle = new Point(positionActuelle.x, positionActuelle.y + 15);
        this.representationGraphique.setPosition(positionActuelle);
      } else if (deplacement <= 50) {
        this.positionActuelle = new Point(positionActuelle.x, positionActuelle.y - 15);
        this.representationGraphique.setPosition(positionActuelle);
      } else if (deplacement <= 75) {
        this.positionActuelle = new Point(positionActuelle.x + 15, positionActuelle.y);
        this.representationGraphique.setPosition(positionActuelle);
      } else if (deplacement <= 100) {
        this.positionActuelle = new Point(positionActuelle.x - 15, positionActuelle.y);
        this.representationGraphique.setPosition(positionActuelle);
      }

    } else {
      this.terrain.supprimerProie(this);
    }

  }
  
  
  
  
  
  /**
   * La proie est morte.
   */
  public void morte() {
    this.mort = true;
    this.representationGraphique.setColor(Color.BLACK);
    System.out.println("MORT!");
  }
  
  public boolean isMort() {
    return this.mort;
  }

}
