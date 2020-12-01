package environnement;

import java.io.File;
import fourmis.Fourmis;
import fourmis.Role;
import role.Reine;


public class Simulateur {

  Journal journal;
  File fichierJournal;
  Fourmiliere laFourmiliere;

  /**
   * Simualteur.
   */
  public Simulateur() {
    File fichierJournal = new File("journal.txt");
    this.journal = new Journal(fichierJournal);
    
    this.creerReine();
  }
  
  private void creerReine() {
    Fourmis fourmis = new Fourmis(null).creerReine();
    Role role = fourmis.getRole();
    Reine reine = (Reine) role; // ou instanceof
    reine.creerFourmiliere();
  }

  /**
   * Main.
   * 
   * @param args Arguments.
   */
  public void main(String[] args) {
    Simulateur simulateur = new Simulateur();
    
    while (true) {
      journal.ecrire(this.laFourmiliere);
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }


  }



}
