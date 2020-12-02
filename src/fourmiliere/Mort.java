package fourmiliere;

import environnement.InformationsFourmiliere;

public class Mort extends Etape {

  Fourmis fourmisMorte;
  
  public Mort(Fourmis fourmis) {
    this.fourmisMorte = fourmis;
  }

  @Override
  protected Etape next() {
    return null;
  }

  @Override
  protected void step() {
  }

  @Override
  protected Role getRole() {
    return null;
  }
  
    
  @Override
  protected void renseignerInformations(InformationsFourmiliere infos) {
    infos.addMort(fourmisMorte);
  }
  
}
