package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Fourmis;
import fourmiliere.Reine;
import fourmiliere.Role;
import fourmiliere.Terrain;
import java.io.File;

public class Simulateur {

  protected final File fichierJournal = new File("journal.txt");
  protected Terrain leTerrain;
  protected Journal journal;
  protected Fourmiliere laFourmiliere;
  protected Reine reine;

  /**
   * Constructeur de la classe Simulateur.
   */
  public Simulateur() {
    this.journal = new Journal(fichierJournal);
    this.leTerrain = new Terrain();
    this.creerReine();
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
  
  /**
   * Créer une Reine en lui associant le terrain de sa fourmiliere.
   */
  protected void creerReine() {
    Fourmis fourmis = new Fourmis(null).creerReine();
    Role role = fourmis.getRole();
    this.reine = (Reine) role; // ou instanceof
    this.laFourmiliere = reine.creerFourmiliere();
    leTerrain.setLaFourmiliere(laFourmiliere);
    laFourmiliere.setLeTerrain(leTerrain);
  }
}