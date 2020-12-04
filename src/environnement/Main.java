package environnement;

import fourmiliere.Adulte;
import fourmiliere.Fourmiliere;
import fourmiliere.Reine;
import fourmiliere.Terrain;


public class Main {

  /**
   * Programme principale.
   * 
   * @param args Arguments
   */
  public static void main(String[] args) {
    Simulateur simulateur = new Simulateur();
    boolean flag = true;
    Reine reine = simulateur.getReine();
    simulateur.getJournal().viderJournal();
    reine.pondre();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    Saison printemps = laFourmiliere.getLeTerrain().getLesSaisons();

    Terrain leTerrain = simulateur.getLeTerrain();

    while (flag) {
      leTerrain.step();
      leTerrain.renseignementFourmiliere();
      simulateur.getJournal().ecrire(leTerrain, printemps.getNbTempsEcoule());
      printemps.incrementerJour();
      if (leTerrain.getInfos().getNbOuvrieres() != 0) {
        flag = false;
      }
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
