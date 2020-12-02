package fourmiliere;

public class Fourmis {

  Etape etape;
  Fourmiliere saFourmiliere;

  public Fourmis(Fourmiliere fourmiliere) {
    this.saFourmiliere = fourmiliere;
    this.etape = new Oeuf(this);
  }

  /**
   * Création d'un reine.
   * 
   * @return un Objet Fourmis dont l'étape est de type Adulte et le role est de type Reine.
   */
  public Fourmis creerReine() {
    Adulte reine = new Adulte(this);
    reine.attributionRoleReine();
    this.etape = reine;

    return this;
  }

  public Role getRole() {
    return this.etape.next().getRole();
  }

  /** . */
  public void step() {
    this.etape = etape.next();
    etape.step();
  }

  public Fourmiliere getFourmiliere() {
    return this.saFourmiliere;
  }

  public void setFourmilliere(Fourmiliere uneFourmilliere) {
    this.saFourmiliere = uneFourmilliere;
  }
  
  public Etape getEtape() {
    return this.etape;
  }
}
