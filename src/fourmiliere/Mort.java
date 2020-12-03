package fourmiliere;

import environnement.InformationsFourmiliere;



public class Mort extends Etape {

  protected Fourmis fourmisMorte;
  protected FourmisGraphique representationGraphique;
  protected int nbStepMort;
  protected final int jourAvantMort = 5;

  /**
   * Constructeur repréentant une fourmis morte.
   * @param fourmis Fourmis morte
   * @param fourmisGraphique Fourmis graphique morte
   */
  public Mort(Fourmis fourmis, FourmisGraphique fourmisGraphique) {
    this.fourmisMorte = fourmis;
    this.representationGraphique = fourmisGraphique;
    this.representationGraphique.mort();
    this.nbStepMort = 0;
  }

  @Override
  protected Role getRole() {
    return null;
  }

  @Override
  protected Etape next() {
    return this;
  }

  @Override
  protected void step() {
    this.nbStepMort++;
    if (this.nbStepMort == jourAvantMort) {
      fourmisMorte.getFourmiliere().ajoutFourmisMorte(this.fourmisMorte);
      this.fourmisMorte.getFourmiliere().getLeTerrain()
          .supprimerFourmisGraphique(this.representationGraphique.getRepresentationGraphique());
    }
  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.incrementerMort();
  }

}
