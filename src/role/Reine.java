package role;

import environnement.Fourmiliere;

public class Reine extends SexueFemelle {

  /**
   * Création d'une fourmiliere;
   * @return
   */
  public Fourmiliere creerFourmiliere() {
    Fourmiliere laFourmiliere = new Fourmiliere(this);
    return laFourmiliere;
    
  }
  
  public void detruireFourmilliere() {
    
  }
}
