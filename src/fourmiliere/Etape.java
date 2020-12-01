package fourmiliere;

public abstract class Etape {

  public Etape() {
  }

  protected abstract Etape next();

  protected abstract void step();
  
  protected abstract Role getRole();

}
