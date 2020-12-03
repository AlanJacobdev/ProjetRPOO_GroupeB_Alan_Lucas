package fourmiliere;

import environnement.InformationsFourmiliere;



public class Mort extends Etape {

  private Fourmis fourmisMorte;
  private FourmisGraphique representationGraphique;
  private int nbStepMort;

  /**
   * Mort.
   * @param fourmis .
   * @param fourmisGraphique .
   */
  public Mort(Fourmis fourmis, FourmisGraphique fourmisGraphique) {
    this.fourmisMorte = fourmis;
    this.representationGraphique = fourmisGraphique;
    this.representationGraphique.mort();
    this.nbStepMort = 0;
  }

  @Override
  protected Etape next() {
    return this;
  }

  @Override
  protected void step() {
    this.nbStepMort++;
    if (this.nbStepMort == 5) {
      fourmisMorte.getFourmiliere().ajoutFourmisMorte(this.fourmisMorte);
      this.fourmisMorte.getFourmiliere().getLeTerrain()
          .supprimerFourmisGraphique(this.representationGraphique.getRepresentationGraphique());
    }
  }

  @Override
  protected Role getRole() {
    return null;
  }


  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.addMort(fourmisMorte);
  }

}
