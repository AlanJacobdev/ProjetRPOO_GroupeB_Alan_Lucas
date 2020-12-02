package environnement;

public class Saison {
  private final int annee = 365;
  private final int printemps = 80;
  private final int ete = 172;
  private final int automne = 266;
  private final int hiver = 356;
  private int nbTempsEcoule;
  
  public Saison() {
    this.nbTempsEcoule = 0;
  }
  
  public int incrementerJour() {
    this.nbTempsEcoule++;
    if(this.nbTempsEcoule > 365) {
      this.nbTempsEcoule = 1;
    }
    
    return this.nbTempsEcoule;
  }
}
