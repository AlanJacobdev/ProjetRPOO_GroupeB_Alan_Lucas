package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Reine;
import fourmiliere.Terrain;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class Main {

  /**
   * Lancement de l'application.
   * 
   * @param args Arguments
   */
  public static void main(String[] args) {

    PrintWriter pw;
    int jour = 0;
    Simulateur simulateur = new Simulateur();
    simulateur.getJournal().viderJournal();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();    
    Terrain leTerrain = parametrageTerrain(laFourmiliere, simulateur);
    
    Saison printemps = laFourmiliere.getLeTerrain().getLesSaisons();
    Reine reine = simulateur.getReine();
    reine.pondre();
    while (reine.isAlive() || laFourmiliere.getFourmis().size() != 0) {
      jour = printemps.getNbTempsEcoule();
      leTerrain.step();
      leTerrain.renseignementFourmiliere();
      simulateur.getJournal().ecrire(leTerrain, jour);
      printemps.incrementerJour();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  /**
   * Parametrage du terrain.
   * @param laFourmiliere   la fourmiliere.
   * @param simulateur  le simulateur.
   * @return Terrain le terrain.
   */
  private static Terrain parametrageTerrain(Fourmiliere laFourmiliere, Simulateur simulateur) {
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
