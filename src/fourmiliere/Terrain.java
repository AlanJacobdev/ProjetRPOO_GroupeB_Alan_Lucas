package fourmiliere;

import environnement.InformationsFourmiliere;
import environnement.Saison;
import java.awt.Dimension;


public class Terrain {

  private Saison lesSaisons;
  private Dimension tailleTerrain;
  private Fourmiliere laFourmiliere;
  private InformationsFourmiliere infos;
  
  public Terrain() {
    this.lesSaisons = new Saison();
    this.tailleTerrain = new Dimension(400,400);
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

  /**
   * .
   */
  public void step() {
    this.laFourmiliere.step();
    this.infos = new InformationsFourmiliere();
  }
  
  

}
