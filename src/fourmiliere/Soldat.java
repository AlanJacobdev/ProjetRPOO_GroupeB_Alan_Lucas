package fourmiliere;

import environnement.InformationsFourmiliere;

public class Soldat extends Role {
  
  protected int age;
  protected int esperanceVie;
  Adulte stadeEvolution;
  
  /**
   * Constructeur du role soldat pour une fourmis adulte.
   * @param adulte Fourmis etant adulte
   */
  public Soldat(Adulte adulte) {
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
    infos.incrementerSoldats();
  }
  
}
