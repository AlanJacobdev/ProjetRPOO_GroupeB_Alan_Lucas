package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Reine;
import fourmiliere.Terrain;
import java.awt.Point;



public class Main {

  /**
   * Lancement de l'application.
   * 
   * @param args Arguments
   */
  public static void main(String[] args) {


    Simulateur simulateur = new Simulateur();
    simulateur.getJournal().viderJournal();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    Terrain leTerrain = parametrageTerrain(simulateur, laFourmiliere);
    Saison printemps = laFourmiliere.getLeTerrain().getLesSaisons();
    Reine reine = simulateur.getReine();
    reine.pondre();
    while (reine.isAlive() || laFourmiliere.getFourmis().size() != 0) {
      leTerrain.step();
      leTerrain.renseignementFourmiliere();
      simulateur.getJournal().ecrire(leTerrain, printemps.getNbTempsEcoule());
      printemps.incrementerJour();
      if (printemps.getNbTempsEcoule() < 120) {
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      } else {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }

  /**
   * Parametrage du terrain.
   * 
   * @param simulateur le simulateur.
   * @param laFourmiliere la fourmiliere.
   * @return Terrain le terrain.
   */
  private static Terrain parametrageTerrain(Simulateur simulateur, Fourmiliere laFourmiliere) {
    Terrain leTerrain = simulateur.getLeTerrain();
    laFourmiliere.setLeTerrain(leTerrain);
    laFourmiliere.setPositionFourmiliere(
        new Point(leTerrain.getTailleTerrain().height, leTerrain.getTailleTerrain().width));
    leTerrain.ajouterFourmiliereGraphique(laFourmiliere.getRepresentationGraphique(),
        laFourmiliere.getRepresentationTerritoire());
    leTerrain.open();

    return leTerrain;
  }

}
