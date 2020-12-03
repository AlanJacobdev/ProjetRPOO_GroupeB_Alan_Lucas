package fourmiliere;

import environnement.InformationsFourmiliere;

public abstract class Role {
  
  /**
   * Faire un pas en avant dans le temps.
   */
  protected abstract void step();

  /**
   * Mourir ou non.
   * @return Etape de la vie de la fourmis.
   */
  protected abstract Etape mourir();

  /**
   * Renseigner les informations relatifs aux Roles et etapes de la fourmis dans le bilan.
   * @param infos Bilan qui sert à connaitre la répartition dans la fourmiliere.
   */
  protected abstract void renseignerInformations(InformationsFourmiliere infos);
  
}
