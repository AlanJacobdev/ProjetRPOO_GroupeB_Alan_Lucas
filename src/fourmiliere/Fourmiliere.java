package fourmiliere;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Fourmiliere {

  List<Fourmis> lesFourmis;
  Fourmis reine;
  InformationsFourmiliere infos;

  /**
   * Constructeur d'une fourmilière.
   * @param reine La fourmis reine.
   */
  public Fourmiliere(Reine reine) {
    this.lesFourmis = new ArrayList<>();
    this.infos = new InformationsFourmiliere();
  }

  /**
   * .
   */
  public void step() {
    for (Fourmis uneFourmis : lesFourmis) {
      uneFourmis.step();
    }
  }

  /**
   * Affichage des informations de la fourmilière.
   * 
   * @return Chaine de caractères contenant les informations.
   */
  public String toString() {
    return this.infos.toString();
  }
}
