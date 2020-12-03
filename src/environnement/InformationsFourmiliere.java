package environnement;

import fourmiliere.Fourmis;
import java.util.ArrayList;
import java.util.List;

public class InformationsFourmiliere {
  int nbOeufs;
  int nbLarves;
  int nbNymphes;
  int nbOuvrieres;
  int nbSoldats;
  int nbSexueFemelles;
  int nbSexueMales;
  int nbMorts;
  
  /**
   * Constructeur d'une classe contenant toutes les informations de mesure de la fourmiliere.
   */
  public InformationsFourmiliere() {
    this.nbOeufs = 0;
    this.nbLarves = 0;
    this.nbNymphes = 0;
    this.nbOuvrieres = 0;
    this.nbSoldats = 0;
    this.nbSexueFemelles = 0;
    this.nbSexueMales = 0;
    this.nbMorts = 0;
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
  
  public void incrementerMort() {
    this.nbMorts++;
  }
  
  public int getNbOeufs() {
    return nbOeufs;
  }

  public int getNbLarves() {
    return nbLarves;
  }

  public int getNbNymphes() {
    return nbNymphes;
  }

  public int getNbOuvrieres() {
    return nbOuvrieres;
  }

  public int getNbSoldats() {
    return nbSoldats;
  }

  public int getNbSexueFemelles() {
    return nbSexueFemelles;
  }

  public int getNbSexueMales() {
    return nbSexueMales;
  }
  
  public int getNbDeMorts() {
    return this.nbMorts;
  }

  
  /**
   * Affichage des informations de la fourmilière.
   * 
   * @return Chaine de caractères contenant les informations.
   */
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("Informations sur la fourmilière :");
    result.append("\n- Nombre d'oeufs : ");
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
    result.append("\n- Nombre de morts : ");
    result.append(this.nbMorts + "\n\n");
    return result.toString();
  }
}
