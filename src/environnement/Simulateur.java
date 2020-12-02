package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Fourmis;
import fourmiliere.Reine;
import fourmiliere.Role;
import fourmiliere.Terrain;
import java.io.File;

public class Simulateur {

  Terrain leTerrain;
  Journal journal;
  File fichierJournal;
  Fourmiliere laFourmiliere;
  Reine reine;

  /**
   * Simualteur.
   */
  public Simulateur() {
    File fichierJournal = new File("journal.txt");
    this.journal = new Journal(fichierJournal);
    this.leTerrain = new Terrain();
    this.creerReine();
  }
  
  private void creerReine() {
    Fourmis fourmis = new Fourmis(null).creerReine();
    Role role = fourmis.getRole();
    this.reine = (Reine) role; // ou instanceof
    this.laFourmiliere = reine.creerFourmiliere();
    leTerrain.setLaFourmiliere(laFourmiliere);
    laFourmiliere.setLeTerrain(leTerrain);
  }
  
  public Reine getReine() {
    return this.reine;
  }
  
  public Journal getJournal() {
    return this.journal;
  }
  
  public Fourmiliere getFourmiliere() {
    return this.laFourmiliere;
  }

  public Terrain getLeTerrain() {
    return leTerrain;
  }

  
  
  
}