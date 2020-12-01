package environnement;

import fourmiliere.Fourmiliere;
import fourmiliere.Fourmis;
import fourmiliere.Reine;
import fourmiliere.Role;
import java.io.File;

public class Simulateur {

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
    
    this.creerReine();
  }
  
  private void creerReine() {
    Fourmis fourmis = new Fourmis(null).creerReine();
    Role role = fourmis.getRole();
    this.reine = (Reine) role; // ou instanceof
    this.laFourmiliere = reine.creerFourmiliere();
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
}