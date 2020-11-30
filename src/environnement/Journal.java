package environnement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Journal {

  private File journalActivite;
  
  public Journal(File fichier) {
    File journalActivite = fichier;

  }

  /**
   * Création d'une nouvelle ligne au journal d'activité.
   * 
   */
  public void ecrire() {

    FileWriter fw;
    try {
      fw = new FileWriter(journalActivite.getAbsoluteFile());

      BufferedWriter bw = new BufferedWriter(fw);
      String nouvelLigne = "LOG";
      bw.write(nouvelLigne);
      bw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }



}
