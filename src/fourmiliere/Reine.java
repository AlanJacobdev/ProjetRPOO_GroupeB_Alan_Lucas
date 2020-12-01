package fourmiliere;

public class Reine extends SexueFemelle {

  Integer age;
  Integer esperanceVie;
  Fourmiliere saFourmilliere;
  
  /**
   * Constructeur.
   */
  public Reine() {
    super(null);
    this.age = 0;
    this.esperanceVie = (int) (Math.random() * (1461 - 3652));
  }
  
  /**
   * Création d'une fourmiliere.
   * @return
   */
  public Fourmiliere creerFourmiliere() {
    Fourmiliere laFourmiliere = new Fourmiliere(this);
    this.saFourmilliere = laFourmiliere;
    return laFourmiliere;
    
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
    
  }
}
