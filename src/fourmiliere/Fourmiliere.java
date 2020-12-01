package fourmiliere;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Fourmiliere {

  List<Fourmis> lesFourmis;
  Integer nbOeufs;
  Integer nbLarves;
  Integer nbNymphes;
  Integer nbOuvrieres;
  Integer nbSoldats;
  Integer nbSexueFemelles;
  Integer nbSexueMales;
  Fourmis reine;

  /**
   * Constructeur d'une fourmilière.
   * @param reine La fourmis reine.
   */
  public Fourmiliere(Reine reine) {
    this.lesFourmis = new ArrayList<>();
    this.nbOeufs = 0;
    this.nbLarves = 0;
    this.nbNymphes = 0;
    this.nbOuvrieres = 0;
    this.nbSoldats = 0;
    this.nbSexueFemelles = 0;
    this.nbSexueMales = 0;
  }

  /**
   * .
   */
  public void step() {
    for (Fourmis uneFourmis : lesFourmis) {
      uneFourmis.step();
    }
  }
  
  public void incrementerOeufs() {
    this.nbOeufs++;
  }

  public void incrementerLarves() {
    this.nbLarves++;
  }

  public void incrementerNymphes() {
    this.nbNymphes++;
  }

  public void incrementerOuvrieres() {
    this.nbOuvrieres++;
  }

  public void incrementerSoldats() {
    this.nbSoldats++;
  }

  public void incrementerSexueFemelle() {
    this.nbSexueFemelles++;
  }

  public void incrementerSexueMale() {
    this.nbSexueMales++;
  }

  public void decrementerOeufs() {
    this.nbOeufs--;
  }

  public void decrementerLarves() {
    this.nbLarves--;
  }

  public void decrementerNymphes() {
    this.nbNymphes--;
  }

  public void decrementerOuvrieres() {
    this.nbOuvrieres--;
  }

  public void decrementerSoldats() {
    this.nbSoldats--;
  }

  public void decrementerSexueFemelle() {
    this.nbSexueFemelles--;
  }

  public void decrementerSexueMale() {
    this.nbSexueMales--;
  }

  /**
   * Affichage des informations de la fourmilière.
   * 
   * @return Chaine de caractères contenant les informations.
   */
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("Informations sur la fourmilière :\n");
    result.append("- Nombre d'oeufs : ");
    result.append(this.nbOeufs);
    result.append("\n- Nombre de larves : ");
    result.append(this.nbLarves);
    result.append("\n- Nombre de nymphes : ");
    result.append(this.nbNymphes);
    result.append("\n- Nombre d'ouvrières : ");
    result.append(this.nbOuvrieres);
    result.append("\n- Nombre de soldats : ");
    result.append(this.nbSoldats);
    result.append("\n- Nombre de femelles : ");
    result.append(this.nbSexueFemelles);
    result.append("\n- Nombre de mâles : ");
    result.append(this.nbSexueMales);
    return result.toString();
  }
}
