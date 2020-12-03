package fourmiliere;

import environnement.InformationsFourmiliere;



public class Fourmis {

  Etape etape;
  Fourmiliere saFourmiliere;

  /**
   * Constructeur d'une fourmis.
   * 
   * @param fourmiliere La fourmilière a laquelle elle est liée
   */
  public Fourmis(Fourmiliere fourmiliere) {
    this.saFourmiliere = fourmiliere;
    this.etape = new Oeuf(this);
  }

  public Role getRole() {
    return this.etape.getRole();
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

  /**
   * Avance d'une certaine duree le temps.
   */
  public void step() {
    this.etape = etape.next();
    etape.step();
  }

  /**
   * Permet de récupérer des informations sur la fourmiliere. Fait circuler le bilan des
   * informations dans aux fourmis prsentent dans la fourmilliere.
   * 
   * @param infos Bilan des informations de la fourmiliere.
   */
  public void renseignementFourmiliere(InformationsFourmiliere infos) {
    this.getEtape().renseignerInformations(infos);
  }

}
