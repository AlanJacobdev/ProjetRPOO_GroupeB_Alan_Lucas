package environnement;

public class Saison {
  private final int annee = 365;
  private final int printemps = 80;
  private final int ete = 172;
  private final int automne = 266;
  private final int hiver = 356;
  private int nbTempsEcoule;
  private int jourDeLannee;

  public Saison() {
    this.nbTempsEcoule = 1;
    this.jourDeLannee = 1;
  }

  /**
   * Incrementation du tempsEcoulé.
   * 
   * @return le jour de l'année
   */
  public int incrementerJour() {
    this.nbTempsEcoule++;
    this.jourDeLannee = nbTempsEcoule % 365;
    if (jourDeLannee == 0) {
      return 1;
    }
    return this.jourDeLannee;
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
