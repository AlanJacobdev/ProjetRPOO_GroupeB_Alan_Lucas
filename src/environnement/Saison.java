package environnement;

public class Saison {
  private final int printemps = 80;
  private final int ete = 172;
  /**
   * Temps écouté depuis la création de la fourmilière.
   */
  private int nbTempsEcoule;
  /**
   * Jour de l'année en cours. Le premier jour s'identifie au 1er janvier.
   */
  private int jourDeLannee;

  /**
   * Constructeur de la classe Saison.
   */
  public Saison() {
    this.nbTempsEcoule = 1;
    this.jourDeLannee = 1;
  }


  public int getNbTempsEcoule() {
    return nbTempsEcoule;
  }


  /**
   * Incrementation du temps ecoule depuis le debut de la fourmiliere.
   *
   */
  public void incrementerJour() {
    this.nbTempsEcoule++;
    this.jourDeLannee = nbTempsEcoule % 365;

    if (jourDeLannee == 0) {
      jourDeLannee = 1;
    }
  }

  /**
   * Savoir si la saison est Printemps.
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
