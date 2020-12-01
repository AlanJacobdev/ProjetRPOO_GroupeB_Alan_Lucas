package fourmiliere;

public class SexueMale extends Sexue {

  Integer age;
  Integer esperanceVie;
  Adulte stadeEvolution;
  
  /**
   * Constructeur.
   * @param adulte Fourmillière
   */
  public SexueMale(Adulte adulte) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.stadeEvolution = adulte;
  }

  @Override
  protected void step() {

  }

  @Override
  protected Etape mourrir() {
    if (this.age >= this.esperanceVie) {
      return new Mort(stadeEvolution.getFourmis());
    }
    return stadeEvolution;
  }

}
