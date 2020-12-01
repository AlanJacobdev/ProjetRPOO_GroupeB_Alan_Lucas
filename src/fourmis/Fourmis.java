package fourmis;

import etape.Adulte;
import etape.Oeuf;
import role.Reine;

public class Fourmis {

  Etape etape;

  public Fourmis() {
    this.etape = new Oeuf();
  }

  public Fourmis(Etape etape) {
    this.etape = etape;
  }

  /**
   * Création d'un reine.
   * @return un Objet Fourmis dont l'étape est de type Adulte et le role est de type Reine.
   */
  public Fourmis creerReine() {
    Adulte reine = new Adulte();
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
