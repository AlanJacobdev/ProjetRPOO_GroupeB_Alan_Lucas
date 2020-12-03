package fourmiliere;

import environnement.InformationsFourmiliere;
import environnement.Saison;

public class Terrain {

  private Saison lesSaisons;
  private Fourmiliere laFourmiliere;
  private InformationsFourmiliere infos;


  /**
   * Constructeur d'un terrain.
   */
  public Terrain() {
    this.lesSaisons = new Saison();
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  public void setLaFourmiliere(Fourmiliere laFourmiliere) {
    this.laFourmiliere = laFourmiliere;
  }


  public Saison getLesSaisons() {
    return lesSaisons;
  }

  public void setLesSaisons(Saison lesSaisons) {
    this.lesSaisons = lesSaisons;
  }

  public InformationsFourmiliere getInfos() {
    return infos;
  }

  public void setInfos(InformationsFourmiliere infos) {
    this.infos = infos;
  }

  /**
   * Avance d'une certaine duree le temps.
   */
  public void step() {
    this.laFourmiliere.step();

  }

  /**
   * Permet de récupérer des informations sur la fourmiliere. Fait circuler le bilan des
   * informations dans aux fourmis presentent dans la fourmilliere.
   */
  public void renseignementFourmiliere() {
    this.infos = new InformationsFourmiliere();
    this.laFourmiliere.renseignementFourmiliere(infos);
  }

  /**
   * Afiiche les informations relatives à la fourmilière.
   */
  @Override
  public String toString() {
    String s = laFourmiliere.toString() + infos.toString();
    return s;
  }





}
