package fourmiliere;


public abstract class Role {

  
  public Role() {
  }
  
  protected abstract void step();

  /**
   * Mourrir ou non.
   * @return l'étape de la vie
   */
  protected abstract Etape mourrir();

  
  protected abstract void renseignerInformations();
  
}
