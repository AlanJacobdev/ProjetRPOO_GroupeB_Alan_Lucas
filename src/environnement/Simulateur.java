package environnement;

import java.io.File;
import fourmis.Fourmis;
import fourmis.Role;
import role.Reine;


public class Simulateur {

  Journal journal;
  File fichierJournal;
  Fourmiliere laFourmiliere;

  public Simulateur() {
    File fichierJournal = new File("journal.txt");
    this.journal = new Journal(fichierJournal);
    
    this.creerReine();
  }
  
  private void creerReine() {
    Fourmis fourmis = new Fourmis().creerReine();
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


    while (true) {
      journal.ecrire();
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }


  }



}
