package fourmiliere;

public class Ouvrier extends Role {
  Integer age;
  Integer esperanceVie;
  Adulte stadeEvolution;

  /**
   * Constructeur.
   * 
   * @param adulte Fourmiliere
   */
  public Ouvrier(Adulte adulte) {
    super();
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (547 - 913));
    this.stadeEvolution = adulte;
  }

  @Override
  protected void step() {

  }

  @Override
  protected void mourrir() {
    // TODO Auto-generated method stub
    
  }

}
