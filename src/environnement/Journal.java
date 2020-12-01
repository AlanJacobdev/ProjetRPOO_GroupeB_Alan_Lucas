package environnement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import fourmiliere.Fourmiliere;

public class Journal {

  private File journalActivite;

  public Journal(File fichier) {
    this.journalActivite = fichier;

  }

  /**
   * Création d'une nouvelle ligne au journal d'activité.
   * 
   */
  public void ecrire(Fourmiliere fourmiliere) {

    FileWriter fw;
    try {
      fw = new FileWriter(journalActivite.getAbsoluteFile());

      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(fourmiliere.toString());
      bw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }



}
