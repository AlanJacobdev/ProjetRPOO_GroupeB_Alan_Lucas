package environnement;

import java.io.File;

public class Simulateur {

  Journal journal;
  File fichierJournal;

  public Simulateur() {
    File fichierJournal = new File("journal.txt");
    this.journal = new Journal(fichierJournal);
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
