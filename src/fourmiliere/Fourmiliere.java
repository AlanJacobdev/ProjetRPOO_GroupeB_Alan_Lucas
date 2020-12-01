package fourmiliere;

import environnement.InformationsFourmiliere;
import java.util.ArrayList;
import java.util.List;


public class Fourmiliere {

  private List<Fourmis> lesFourmis;
  private List<Fourmis> lesFourmisMortes;
  private Fourmis reine;
  private InformationsFourmiliere infos;

  /**
   * Constructeur d'une fourmilière.
   * 
   * @param reine La fourmis reine.
   */
  public Fourmiliere(Reine reine) {
    this.lesFourmis = new ArrayList<>();
    this.infos = new InformationsFourmiliere();
    this.lesFourmisMortes = new ArrayList<>();
  }

  /**
   * .
   */
  public void step() {
    for (Fourmis uneFourmis : lesFourmis) {
      uneFourmis.step();
    }
    if (this.lesFourmisMortes.size() > 0) {
      this.removeFourmis();
    }
  }

  /**
   * Créer une portée de fourmis.
   * 
   * @param nombre : Nombre de fourmis à créer.
   */
  public void nouvellesFourmis(Integer nombre) {
    for (int i = 0; i < nombre; i++) {
      this.lesFourmis.add(new Fourmis(this));
    }
  }

  public InformationsFourmiliere getInfos() {
    return this.infos;
  }
  
  public void ajoutFourmisMorte(Fourmis fourmis) {
    this.lesFourmisMortes.add(fourmis);
  }

  private void removeFourmis() {
    for (Fourmis fourmis : this.lesFourmisMortes) {
      this.lesFourmis.remove(fourmis);
    }
    this.lesFourmisMortes = new ArrayList<>();
  }

  public List<Fourmis> getFourmis() {
    return this.lesFourmis;
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
