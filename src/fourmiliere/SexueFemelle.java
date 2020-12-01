package fourmiliere;

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
    this.esperanceVie = (int) (Math.random() * (547 - 913));
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
      fourmis.getFourmiliere().getInfos().decrementerSexueFemelle();
      fourmis.getFourmiliere().ajoutFourmisMorte(fourmis);
      return new Mort(fourmis);
    }
    return stadeEvolution;
  }

  
}
