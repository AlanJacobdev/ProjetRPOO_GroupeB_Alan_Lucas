package fourmiliere;

import environnement.InformationsFourmiliere;

public class SexueMale extends Sexue {

  protected int age;
  protected int esperanceVie;
  protected Adulte stadeEvolution;
  
  /**
   * Constructeur du rôle Sexue Male pour une fourmis adulte.
   * @param adulte Fourmis étant adulte
   */
  public SexueMale(Adulte adulte) {
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
  protected Etape mourir() {
    if (this.age >= this.esperanceVie) {
      Fourmis fourmis = this.stadeEvolution.getFourmis();
      return new Mort(fourmis, this.stadeEvolution.getRepresentationGraphique());
    }
    return stadeEvolution;
  }

  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.incrementerSexueMale();
  }
  
}
