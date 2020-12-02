package vue;

import graphicLayer.GRect;
import java.awt.Color;
import java.awt.Dimension;
import fourmiliere.Fourmiliere;


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
    this.laFourmiliereVue.setDimension(new Dimension(10, 10));
  }

  public GRect getLaFourmiliereVue() {
    return laFourmiliereVue;
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  

}
