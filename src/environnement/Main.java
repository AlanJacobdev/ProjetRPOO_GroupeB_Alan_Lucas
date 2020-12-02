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
    Saison printemps = new Saison();
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
    while ((lesInfos.getNbOeufs() > 0 || lesInfos.getNbLarves() > 0)
        || lesInfos.getNbNymphes() > 0) {
      jour = printemps.incrementerJour();
      simulateur.getLeTerrain().step();
      simulateur.getJournal().ecrire(laFourmiliere, jour);
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
