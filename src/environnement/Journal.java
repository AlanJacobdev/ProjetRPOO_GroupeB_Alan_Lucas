package environnement;

import fourmiliere.Terrain;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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



}
