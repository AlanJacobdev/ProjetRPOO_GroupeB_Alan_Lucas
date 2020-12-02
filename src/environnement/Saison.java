package environnement;

public class Saison {
  private final int annee = 365;
  private final int printemps = 80;
  private final int ete = 172;
  private int nbTempsEcoule;
  private int jourDeLannee;

  public Saison() {
    this.nbTempsEcoule = 1;
    this.jourDeLannee = 1;
  }

  
  public int getNbTempsEcoule() {
    return nbTempsEcoule;
  }

  
  /**
   * Incrementation du tempsEcoulé.
   * 
   */
  public void incrementerJour() {
    this.nbTempsEcoule++; 
    this.jourDeLannee = nbTempsEcoule % annee;
    
    if (jourDeLannee == 0) {
      jourDeLannee = 1;
    }
  }

  /**
   * Savoir si la saison est Priintemps.
   * 
   * @return <b>true</b> si la saison est printemps sinon <b>false</b>
   */
  public boolean isPrintemps() {
   
    if (jourDeLannee >= printemps && jourDeLannee < ete) {
      return true;
    }
    return false;
  }
}
