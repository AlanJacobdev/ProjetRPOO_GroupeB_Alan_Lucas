package fourmiliere;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class DeplacementPheromone {

  private static DeplacementPheromone maMethodeDeplacement = new DeplacementPheromone();

  private DeplacementPheromone() {}

  public static DeplacementPheromone getDeplacement() {
    return maMethodeDeplacement;
  }

  /**
   * Méthode retournant le pourcentage de chance de se déplacer vers une direction en fonction des
   * phéromones présent dans ses alentours ( 1 case adjaçante à la position).
   * 
   * @param f Fourmi adulte qui souhaite se déplacer.
   * @return
   *         <p>
   *         La liste des poucentage : <br/>
   *         0 Vers le haut <br/>
   *         1 Vers le bas<br/>
   *         2 Vers la droite <br/>
   *         3 Vers la gauche
   *         </p>
   */
  public List<Integer> calculPourcentageDeplacement(Adulte f) {
    List<Integer> liste = new ArrayList<Integer>();
    Boolean pheromoneDroit = false;
    Boolean pheromoneGauche = false;
    Boolean pheromoneHaut = false;
    Boolean pheromoneBas = false;
    int nombrePheromone = 0;
    Point coordonneesFourmi = f.getRepresentationGraphique().getCoordonneesActuelle();
    Pheromone haut = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x, coordonneesFourmi.y + 5);
    Pheromone bas = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x, coordonneesFourmi.y - 5);
    Pheromone droite = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x + 5, coordonneesFourmi.y);
    Pheromone gauche = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x - 5, coordonneesFourmi.y);
    int intensiteHaut = haut.getIntensitePheromone();
    int intensiteBas = bas.getIntensitePheromone();
    int intensiteDroit = droite.getIntensitePheromone();
    int intensiteGauche = gauche.getIntensitePheromone();
    if (intensiteBas > 0) {
      pheromoneBas = true;
      nombrePheromone++;
    }
    if (intensiteHaut > 0) {
      pheromoneHaut = true;
      nombrePheromone++;
    }
    if (intensiteDroit > 0) {
      pheromoneDroit = true;
      nombrePheromone++;
    }
    if (intensiteGauche > 0) {
      pheromoneGauche = true;
      nombrePheromone++;
    }

    if (nombrePheromone == 1) {
      if (pheromoneHaut) {
        liste.add(40);
      } else {
        liste.add(20);
      }
      if (pheromoneBas) {
        liste.add(40);
      } else {
        liste.add(20);
      }
      if (pheromoneDroit) {
        liste.add(40);
      } else {
        liste.add(20);
      }
      if (pheromoneGauche) {
        liste.add(40);
      } else {
        liste.add(20);
      }
    } else if (nombrePheromone == 2) {
      if (pheromoneHaut) {
        liste.add(35);
      } else {
        liste.add(15);
      }
      if (pheromoneBas) {
        liste.add(35);
      } else {
        liste.add(15);
      }
      if (pheromoneDroit) {
        liste.add(35);
      } else {
        liste.add(15);
      }
      if (pheromoneGauche) {
        liste.add(35);
      } else {
        liste.add(15);
      }
    } else if (nombrePheromone == 3) {
      if (pheromoneHaut) {
        liste.add(30);
      } else {
        liste.add(10);
      }
      if (pheromoneBas) {
        liste.add(30);
      } else {
        liste.add(10);
      }
      if (pheromoneDroit) {
        liste.add(30);
      } else {
        liste.add(10);
      }
      if (pheromoneGauche) {
        liste.add(30);
      } else {
        liste.add(10);
      }
    } else {
      liste.add(25);
      liste.add(25);
      liste.add(25);
      liste.add(25);
    }
    return liste;
  }

}
