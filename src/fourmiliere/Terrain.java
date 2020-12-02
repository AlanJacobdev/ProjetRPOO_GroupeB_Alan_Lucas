package fourmiliere;

import environnement.Saison;

public class Terrain {

  Saison lesSaisons;


  Fourmiliere laFourmiliere;

  public Terrain() {
    this.lesSaisons = new Saison();
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

  
  /**
   * .
   */
  public void step() {
    this.laFourmiliere.step();
  }
  
  

}
