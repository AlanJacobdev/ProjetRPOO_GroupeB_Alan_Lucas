package environnement;

import fourmiliere.Fourmiliere;

public class Main {

  /**
   * main.
   * @param args : jdbfhjsufvsb
   */
  public static void main(String[] args) {
    Simulateur simulateur = new Simulateur();
    simulateur.getReine().pondre(10);
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    while (true) {
      simulateur.getJournal().ecrire(laFourmiliere);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}