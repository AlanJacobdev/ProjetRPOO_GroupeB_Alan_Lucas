package fourmiliere;

public class Soldat extends Role {
  Integer age;
  Integer esperanceVie;
  Adulte stadeEvolution;
  
  /**
   * Constructeur.
   * @param adulte Fourmilliere 
   */
  public Soldat(Adulte adulte) {
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
      fourmis.getFourmiliere().getInfos().decrementerSoldats();
      fourmis.getFourmiliere().ajoutFourmisMorte(fourmis);
      return new Mort(fourmis);
    }
    return stadeEvolution;
  }

}
