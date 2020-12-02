package fourmiliere;

import environnement.Saison;

public class Reine extends SexueFemelle {

  private Integer age;
  private Integer esperanceVie;
  private Adulte stadeEvolution;
  private int oeufsPondus;

  /**
   * Constructeur.
   */

  public Reine(Adulte adulte) {
    super(adulte);
    this.stadeEvolution = adulte;
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (3652 - 1461)) + 1461;
  }


  /**
   * Création d'une fourmiliere.
   * 
   * @return
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
    this.pondre();
    
  }

  @Override
  protected Etape mourrir() {
    if (this.age >= this.esperanceVie) {
      detruireFourmilliere();
      return new Mort(stadeEvolution.getFourmis());
    }
    return stadeEvolution;
  }

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
   * Créer une portée de fourmis.
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
