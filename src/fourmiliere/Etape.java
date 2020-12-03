package fourmiliere;

import environnement.InformationsFourmiliere;

public abstract class Etape {

  /**
   * Retourne l'étape actuelle de la fourmis.
   * @return Etape 
   */
  protected abstract Etape next();

  /**
   * Avance d'une certaine durée le temps.
   */
  protected abstract void step();
  
  /**
   * Retourne le rôle dans le cas d'un adulte.
   * @return <b>Role</b> si la fourmis est adulte sinon <b>false</b>
   */
  protected abstract Role getRole();

  /**
   * Permet de récupérer des informations sur la fourmiliere. Fait circuler le bilan des
   * informations dans aux fourmis prsentent dans la fourmilliere.
   * 
   * @param infos Bilan des informations de la fourmiliere.
   */
  protected abstract void renseignerInformations(InformationsFourmiliere infos);
  
}
