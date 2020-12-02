package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Terrain;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import vue.VueFourmiliere;
import vue.VueTerrain;



public class Main {

  /**
   * Main.
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
    simulateur.getReine().pondre();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    Saison printemps = laFourmiliere.getLeTerrain().getLesSaisons();
    
    Terrain leTerrain = simulateur.getLeTerrain();
    InformationsFourmiliere lesInfos = leTerrain.getInfos();
    VueTerrain leTerrainVue = new VueTerrain(leTerrain);
    leTerrainVue.open();
    VueFourmiliere laFourmiliereVue = new VueFourmiliere(laFourmiliere);
    leTerrainVue.addFourmiliere(laFourmiliereVue);
    
    
    while (printemps.getNbTempsEcoule() < 365) {
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

}
