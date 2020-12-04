package fourmiliere;

import environnement.Saison;

public class Reine extends SexueFemelle {

  protected Integer age;
  protected Integer esperanceVie;
  protected Adulte stadeEvolution;
  protected int oeufsPondus;

  /**
   * Constructeur du role Reine pour une fourmis adulte. Une fourmilliere ne peut en contenir
   * qu'une.
   * 
   * @param adulte Fourmis etant adulte
   */
  public Reine(Adulte adulte) {
    super(adulte);
    this.stadeEvolution = adulte;
    this.age = 0;
    // this.esperanceVie = (int) (Math.random() * (3652 - 1461)) + 1461;
    this.esperanceVie = (int) (Math.random() * (400 - 350)) + 350;
  }

  public int getOeufsPondus() {
    return this.oeufsPondus;
  }

  /**
   * Creation d'une fourmiliere dont-elle est la reine.
   * 
   * @return La nouvelle Fourmiliere.
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
    if (this.isAlive()) {
      this.pondre();
    }
  }

  @Override
  protected Etape mourir() {
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
   */
  public void pondre() {
    Fourmis fourmis = this.stadeEvolution.getFourmis();
    Fourmiliere fourmiliere = fourmis.getFourmiliere();
    Saison laSaison = fourmiliere.getLeTerrain().getLesSaisons();
    if (laSaison.isPrintemps() && this.age % 20 == 0) {
      oeufsPondus = (int) (Math.random() * (3 - 1)) + 1;
      this.stadeEvolution.getFourmis().getFourmiliere().nouvellesFourmis(oeufsPondus);
    }
  }

}
