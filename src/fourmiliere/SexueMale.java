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
      fourmis.getFourmiliere().getInfos().addMort(fourmis);
      fourmis.getFourmiliere().getInfos().decrementerSexueMale();
      fourmis.getFourmiliere().ajoutFourmisMorte(fourmis);
      return new Mort(fourmis);
    }
    return stadeEvolution;
  }

}
