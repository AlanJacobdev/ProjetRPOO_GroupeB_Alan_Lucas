package fourmiliere;

import environnement.InformationsFourmiliere;

public class SexueFemelle extends Sexue {
  Integer age;
  Integer esperanceVie;
  Adulte stadeEvolution;

  /**
   * Constructeur.
   * 
   * @param adulte Fourmilliere
   */
  public SexueFemelle(Adulte adulte) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (913 - 547)) + 547;
    this.stadeEvolution = adulte;
  }

  @Override
  protected void step() {
    age++;
  }
  
  @Override
  protected Etape mourrir() {
    if (this.age >= this.esperanceVie) {
      Fourmis fourmis = this.stadeEvolution.getFourmis();
      fourmis.getFourmiliere().ajoutFourmisMorte(fourmis);
      return new Mort(fourmis);
    }
    return stadeEvolution;
  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.incrementerSexueFemelle();
  }
  
}
