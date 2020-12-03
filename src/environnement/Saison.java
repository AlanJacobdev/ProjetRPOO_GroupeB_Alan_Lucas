package environnement;

public class Saison {
  protected final int annee = 365;
  protected final int printemps = 80;
  protected final int ete = 172;
  /**
   * Temps écouté depuis la création de la fourmilière.
   */
  protected int nbTempsEcoule;
  /**
   * Jour de l'année en cours. Le premier jour s'identifie au 1er janvier.
   */
  protected int jourDeLannee;

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
   * Incrementation du temps écoulé depuis le début de la fourmilière.
   */
  public void incrementerJour() {
    this.nbTempsEcoule++;
    this.jourDeLannee = nbTempsEcoule % annee;
    if (jourDeLannee == 0) {
      jourDeLannee = 1;
    }
  }

  /**
   * Savoir si la saison actuelle est le Printemps.
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
