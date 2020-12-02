package environnement;

import fourmiliere.Fourmiliere;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Main {

  /**
   * main.
   * 
   * @param args : jdbfhjsufvsb
   */
  public static void main(String[] args) {
    Simulateur simulateur = new Simulateur();
    
    PrintWriter pw;
    int jour = 0;
    try {
      pw = new PrintWriter("journal.txt");
      pw.close();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }

    simulateur.getReine().pondre();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    InformationsFourmiliere lesInfos = laFourmiliere.getInfos();
    Saison printemps = laFourmiliere.getLeTerrain().getLesSaisons();
    while (printemps.getNbTempsEcoule() < 365
        || (lesInfos.getNbOeufs() > 0 || lesInfos.getNbLarves() > 0)
        || lesInfos.getNbNymphes() > 0) {
      jour = printemps.getNbTempsEcoule();
      simulateur.getLeTerrain().step();
      simulateur.getReine().pondre();
      simulateur.getJournal().ecrire(laFourmiliere, jour);
      printemps.incrementerJour();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
