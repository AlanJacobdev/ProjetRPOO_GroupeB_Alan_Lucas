package fourmiliere;

public class Reine extends SexueFemelle {

  private Integer age;
  private Integer esperanceVie;
  private Adulte stadeEvolution;

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
    Fourmiliere laFourmiliere = new Fourmiliere(this);
    Fourmis fourmis = this.stadeEvolution.getFourmis();
    fourmis.setFourmilliere(laFourmiliere);
    return laFourmiliere;
  }

  @Override
  protected void step() {
    age++;
  }

  @Override
  protected Etape mourrir() {
    System.out.println(age);
    System.out.println(esperanceVie);
    if (this.age >= this.esperanceVie) {
      detruireFourmilliere();
      return new Mort(stadeEvolution.getFourmis());
    }
    return stadeEvolution;
  }

  public void detruireFourmilliere() {
    this.saFourmilliere = null;
  }

  /**
   * Créer une portée de fourmis.
   * 
   * @param nombre : Nombre de fourmis à créer.
   */
  public void pondre(Integer nombre) {
    this.saFourmilliere.nouvellesFourmis(nombre);
  }
}
