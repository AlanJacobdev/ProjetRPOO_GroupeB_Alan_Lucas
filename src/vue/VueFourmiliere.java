package vue;

import fourmiliere.Fourmiliere;
import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;


public class VueFourmiliere {

  GRect laFourmiliereVue;
  Fourmiliere laFourmiliere;

  /**
   * Constructeur.
   */
  public VueFourmiliere(Fourmiliere uneFourmiliere) {
    this.laFourmiliere = uneFourmiliere;
    this.laFourmiliereVue = new GRect();
    this.laFourmiliereVue.setColor(Color.YELLOW);
    this.laFourmiliereVue.setDimension(new Dimension(20, 20));
  }

  public GRect getLaFourmiliereVue() {
    return laFourmiliereVue;
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  

}
