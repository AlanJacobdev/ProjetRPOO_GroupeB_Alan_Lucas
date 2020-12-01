package environnement;

import fourmiliere.Fourmiliere;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Main {

  /**
   * main.
   * @param args : jdbfhjsufvsb
   */
  public static void main(String[] args) {
    Simulateur simulateur = new Simulateur();
    PrintWriter pw;
    try {
      pw = new PrintWriter("journal.txt");
      pw.close();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }
    
    simulateur.getReine().pondre(10);
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    while (true) {
      laFourmiliere.step();
      simulateur.getJournal().ecrire(laFourmiliere);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}