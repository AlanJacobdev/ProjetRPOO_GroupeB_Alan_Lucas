package fourmiliere;

import environnement.Saison;

public class Reine extends SexueFemelle {

  private Integer age;
  private Integer esperanceVie;
  private Adulte stadeEvolution;
  private int oeufsPondus;

  /**
   * Constructeur du role Reine pour une fourmis adulte.
   * une fourmiliere ne peut en contenir qu'une.
   * @param adulte Fourmis etant adulte.
   */
  public Reine(Adulte adulte) {
    super(adulte);
    this.stadeEvolution = adulte;
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (3652 - 1461)) + 1461;
  }

  public int getOeufsPondus() {
    return this.oeufsPondus;
  }

  /**
   * Creation d'une fourmiliere dont-elle est la reine.
   * @return la nouvelle fourmiliere.
   */
  public Fourmiliere creerFourmiliere() {
    Fourmiliere laFourmiliere = new Fourmiliere(this.stadeEvolution.getFourmis());
    Fourmis fourmis = this.stadeEvolution.getFourmis();
    fourmis.setFourmilliere(laFourmiliere);
    return laFourmiliere;
  }

  @Override
  protected void step() {
    age++;
    if (this.isAlive()){
      this.pondre();
    }
  }

  /**
   * Si la fourmis atteint son esperance de vie elle meure, alors elle retourne son nouvel etat
   * mort. <br>
   * Sinon retourne son etape adulte.
   */
  @Override
  protected Etape mourrir() {
    return stadeEvolution;
  }

  /**
   * Detruit la fourmiliere.
   */
  public void detruireFourmilliere() {
    this.stadeEvolution.getFourmis().setFourmilliere(null);
  }

  /**
   * Savoir si la reine est vivante.
   *
   * @return <b>true</b> si la reine est vivante sinon <b>false</b>
   */
  public boolean isAlive() {
    if (age < esperanceVie) {
      return true;
    }
    return false;
  }

  /**
   * Creer une portée de X fourmis.
   *
   */
  public void pondre() {
    Fourmis fourmis = this.stadeEvolution.getFourmis();
    Fourmiliere fourmiliere = fourmis.getFourmiliere();
    Saison laSaison = fourmiliere.getLeTerrain().getLesSaisons();
    if (laSaison.isPrintemps()) {
      oeufsPondus = (int) (Math.random() * (20 - 10)) + 10;
      this.stadeEvolution.getFourmis().getFourmiliere().nouvellesFourmis(oeufsPondus);
    }
  }
}
