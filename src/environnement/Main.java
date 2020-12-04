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
    try {
      pw = new PrintWriter("journal.txt");
      pw.close();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }
    Simulateur simulateur = new Simulateur();

    Fourmiliere laFourmiliere = simulateur.getFourmiliere();

    Terrain leTerrain = simulateur.getLeTerrain();
    laFourmiliere.setLeTerrain(leTerrain);
    laFourmiliere.setPositionFourmiliere(
        new Point(leTerrain.getTailleTerrain().height, leTerrain.getTailleTerrain().width));
    leTerrain.ajouterFourmiliereGraphique(laFourmiliere.getRepresentationGraphique(),
        laFourmiliere.getRepresentationTerritoire());
    leTerrain.open();
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
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
