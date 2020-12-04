package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Terrain;


public class Main {

  /**
   * Programme principale.
   * 
   * @param args Arguments
   */
  public static void main(String[] args) {
    Simulateur simulateur = new Simulateur();
    simulateur.getJournal().viderJournal();
    simulateur.getReine().pondre();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    Saison printemps = laFourmiliere.getLeTerrain().getLesSaisons();
    
    Terrain leTerrain = simulateur.getLeTerrain();

    while (printemps.getNbTempsEcoule() < 365) {
      leTerrain.step();
      leTerrain.renseignementFourmiliere();
      simulateur.getJournal().ecrire(leTerrain, printemps.getNbTempsEcoule());
      printemps.incrementerJour();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
