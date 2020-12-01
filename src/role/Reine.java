package role;

import environnement.Fourmiliere;

public class Reine extends SexueFemelle {

  public Fourmiliere creerFourmiliere() {
    Fourmiliere laFourmiliere = new Fourmiliere(this);
    return laFourmiliere;
  }
}
