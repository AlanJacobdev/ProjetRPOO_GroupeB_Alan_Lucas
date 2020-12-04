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
   *         La liste des poucentage (case): <br/>
   *         0 Vers le haut <br/>
   *         1 Vers le bas<br/>
   *         2 Vers la droite <br/>
   *         3 Vers la gauche
   *         </p>
   */
  public List<Integer> calculPourcentageDeplacement(Adulte f) {
    Boolean pheromoneDroit = false;
    Boolean pheromoneGauche = false;
    Boolean pheromoneHaut = false;
    Boolean pheromoneBas = false;
    int nombrePheromone = 0;
    Point coordonneesFourmi = f.getRepresentationGraphique().getCoordonneesActuelle();
    Pheromone bas = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x, coordonneesFourmi.y - 5);
    
    int intensiteBas = bas.getIntensitePheromone();
    if (intensiteBas > 0) {
      pheromoneBas = true;
      nombrePheromone++;
    }
    Pheromone haut = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x, coordonneesFourmi.y + 5);
    int intensiteHaut = haut.getIntensitePheromone();
    if (intensiteHaut > 0) {
      pheromoneHaut = true;
      nombrePheromone++;
    }
    Pheromone droite = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x + 5, coordonneesFourmi.y);
    int intensiteDroit = droite.getIntensitePheromone();
    if (intensiteDroit > 0) {
      pheromoneDroit = true;
      nombrePheromone++;
    }
    Pheromone gauche = f.getFourmis().getFourmiliere().getLeTerrain()
        .getUnPheromone(coordonneesFourmi.x - 5, coordonneesFourmi.y);
    int intensiteGauche = gauche.getIntensitePheromone();
    if (intensiteGauche > 0) {
      pheromoneGauche = true;
      nombrePheromone++;
    }
    return this.creerListeDeplacement(nombrePheromone, pheromoneHaut, pheromoneBas, pheromoneDroit,
        pheromoneGauche);
  }

  /**
   * Créer la liste qui regroupe les pourcentages de déplacement en fonction du nombre de phéromones
   * et leur présence autour de la fourmi.
   * 
   * @param nombrePheromone Nombre de phéromones entourant la fourmis (max 4)
   * @param pheromoneHaut   Présence de phéromone sur la cas du haut ou non
   * @param pheromoneBas    Présence de phéromone sur la cas du bas ou non
   * @param pheromoneDroit  Présence de phéromone sur la cas du droit ou non
   * @param pheromoneGauche Présence de phéromone sur la cas du gauche ou non
   * @return Liste contenant les pourcentages de déplacement tel que [Haut,Bas,Droite,Gauche]
   */
  public List<Integer> creerListeDeplacement(int nombrePheromone, Boolean pheromoneHaut,
      Boolean pheromoneBas, Boolean pheromoneDroit, Boolean pheromoneGauche) {
    List<Integer> liste = new ArrayList<Integer>();

    if (nombrePheromone == 1) {
      if (pheromoneHaut ? liste.add(40) : liste.add(20))
        ;
      if (pheromoneBas ? liste.add(40) : liste.add(20))
        ;
      if (pheromoneDroit ? liste.add(40) : liste.add(20))
        ;
      if (pheromoneGauche ? liste.add(40) : liste.add(20))
        ;
    } else if (nombrePheromone == 2) {
      if (pheromoneHaut ? liste.add(35) : liste.add(15))
        ;
      if (pheromoneBas ? liste.add(35) : liste.add(15))
        ;
      if (pheromoneDroit ? liste.add(35) : liste.add(15))
        ;
      if (pheromoneGauche ? liste.add(35) : liste.add(15))
        ;
    } else if (nombrePheromone == 3) {
      if (pheromoneHaut ? liste.add(30) : liste.add(10))
        ;
      if (pheromoneBas ? liste.add(30) : liste.add(10))
        ;
      if (pheromoneDroit ? liste.add(30) : liste.add(10))
        ;
      if (pheromoneGauche ? liste.add(30) : liste.add(10))
        ;
    } else {
      liste.add(25);
      liste.add(25);
      liste.add(25);
      liste.add(25);
    }
    return liste;
  }
}
