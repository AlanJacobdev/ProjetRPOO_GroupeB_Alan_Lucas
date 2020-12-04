package environnement;

import fourmiliere.Terrain;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Journal {

  private File journalActivite;

  public Journal(File fichier) {
    this.journalActivite = fichier;

  }

  /**
   * Création d'une nouvelle ligne au journal d'activité.
   * 
   */
  public void ecrire(Terrain leTerrain, int jour) {

    FileWriter fw;
    try {
      fw = new FileWriter(journalActivite.getAbsoluteFile(), true);
      fw.write("Jour n°" + jour + "\n");
      fw.write(leTerrain.toString());
      fw.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Vide le journal.
   */
  public void viderJournal() {
    PrintWriter pw;
    try {
      pw = new PrintWriter(journalActivite);
      pw.close();
    } catch (FileNotFoundException e1) {
      e1.printStackTrace();
    }
  }

}
