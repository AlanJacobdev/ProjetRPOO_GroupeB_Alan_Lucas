package fourmis;

import environnement.Fourmiliere;
import etape.Adulte;
import etape.Oeuf;

public class Fourmis {

  Etape etape;
  Fourmiliere saFourmiliere;
  
  public Fourmis(Fourmiliere fourmiliere) {
    this.etape = new Oeuf(fourmiliere);
    this.saFourmiliere = fourmiliere;
  }

  /**
   * Création d'un reine.
   * @return un Objet Fourmis dont l'étape est de type Adulte et le role est de type Reine.
   */
  public Fourmis creerReine() {
    Adulte reine = new Adulte(null);
    reine.attributionRoleReine();
    this.etape = reine;

    return this;
  }
  
  public Role getRole() {
    return this.etape.next().getRole();
  }

  public void step() {
    this.etape = etape.next();
    etape.step();
  }


}
