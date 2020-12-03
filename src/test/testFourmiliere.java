package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import environnement.InformationsFourmiliere;
import environnement.Saison;
import environnement.Simulateur;
import fourmiliere.Adulte;
import fourmiliere.Fourmiliere;
import fourmiliere.Fourmis;
import fourmiliere.Larve;
import fourmiliere.Nymphe;
import fourmiliere.Oeuf;
import fourmiliere.Ouvrier;
import fourmiliere.SexueFemelle;
import fourmiliere.SexueMale;
import fourmiliere.Soldat;
import fourmiliere.Terrain;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class testFourmiliere {
  
  private void oeufToLarve(Fourmis fourmis) {
    for (int i = 0; i < 4; i++) {
      fourmis.step();
    }
  }
  
  private void larveToNymphe(Fourmis fourmis) {
    for (int i = 0; i < 10; i++) {
      fourmis.step();
    }
  }
  
  private void NympheToAdulte(Fourmis fourmis) {
    for (int i = 0; i < 10; i++) {
      fourmis.step();
    }
  }
  
  private void pondre(Saison saison) {
    for(int i = 0; i < 90; i++) {
      saison.incrementerJour();
    }
  }
  
  private void avancerTemps(Terrain terrain, Saison saison) {
    for(int i = 0; i < 130; i++) {
      terrain.step();
      terrain.renseignementFourmiliere();
      saison.incrementerJour();
    }
  }

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void testSimulateur() {
    Simulateur simulateur = new Simulateur();
    assertNotNull(simulateur);
    assertNotNull(simulateur.getReine());
    assertNotNull(simulateur.getJournal());
    assertNotNull(simulateur.getLeTerrain());
    assertNotNull(simulateur.getFourmiliere());
  }
  
  @Test
  void testFourmiliereInstance() {
    Simulateur simulateur = new Simulateur();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    assertNotNull(laFourmiliere);
    assertNotNull(laFourmiliere.getFourmis());
    assertTrue(laFourmiliere.getFourmis().size() == 0);
    assertNotNull(laFourmiliere.getLeTerrain());
    assertNotNull(laFourmiliere.getLesFourmisMortes());
    assertTrue(laFourmiliere.getLesFourmisMortes().size() == 0);
    
    laFourmiliere.nouvellesFourmis(1);
    assertTrue(laFourmiliere.getFourmis().size() == 1);
    Fourmis fourmis = laFourmiliere.getFourmis().get(0);
    assertNotNull(fourmis);
    
    Fourmis fourmisMorte = new Fourmis(laFourmiliere);
    laFourmiliere.ajoutFourmisMorte(fourmisMorte);
    assertTrue(laFourmiliere.getLesFourmisMortes().size() == 1);
    
    Terrain terrain = new Terrain();
    assertNotNull(terrain);
    laFourmiliere.setLeTerrain(terrain);
  }
  
  @Test
  void testFourmis() {
    Simulateur simulateur = new Simulateur();
    Fourmiliere laFourmiliere = simulateur.getFourmiliere();
    Fourmis fourmis = new Fourmis(laFourmiliere);
    assertNotNull(fourmis);
    assertNotNull(fourmis.getEtape());
    assertNotNull(fourmis.getFourmiliere());
    assertEquals(fourmis.getFourmiliere(), laFourmiliere);
    assertNull(fourmis.getRole());
    assertTrue(fourmis.getEtape() instanceof Oeuf);
    
    Simulateur simulateur2 = new Simulateur();
    Fourmiliere fourmiliere2 = simulateur2.getFourmiliere();
    fourmis.setFourmilliere(fourmiliere2);
    assertNotNull(fourmis.getFourmiliere());
    assertNotEquals(fourmis.getFourmiliere(), laFourmiliere);
    assertEquals(fourmis.getFourmiliere(), fourmiliere2);
    fourmis.setFourmilliere(laFourmiliere);
    
    this.oeufToLarve(fourmis);
    assertTrue(fourmis.getEtape() instanceof Larve);
    this.larveToNymphe(fourmis);
    assertTrue(fourmis.getEtape() instanceof Nymphe);
    this.NympheToAdulte(fourmis);
    assertTrue(fourmis.getEtape() instanceof Adulte);
  }
  
  @Test
  void testCreerReine() {
    Simulateur simulateur = new Simulateur();
    assertNotNull(simulateur.getReine());
    assertTrue(simulateur.getReine() instanceof SexueFemelle);
    assertTrue(simulateur.getReine().isAlive());
    simulateur.getReine().pondre();
    assertTrue(simulateur.getReine().getOeufsPondus() == 0);
    Fourmiliere fourmiliere = simulateur.getFourmiliere();
    assertNotNull(fourmiliere);
    assertNotNull(fourmiliere.getFourmis());
    assertTrue(fourmiliere.getFourmis().size() == 0);
  }
  
  @Test
  void testPonte() {
    Simulateur simulateur = new Simulateur();
    assertNotNull(simulateur.getReine());
    this.pondre(simulateur.getFourmiliere().getLeTerrain().getLesSaisons());
    assertTrue(simulateur.getFourmiliere().getLeTerrain().getLesSaisons().isPrintemps());
    simulateur.getReine().pondre();
    assertFalse(simulateur.getReine().getOeufsPondus() == 0);
    assertNotNull(simulateur.getFourmiliere().getFourmis());
    assertFalse(simulateur.getFourmiliere().getFourmis().size() == 0);
    List<Fourmis> lesFourmis = simulateur.getFourmiliere().getFourmis();
    assertTrue(lesFourmis.get(0).getEtape() instanceof Oeuf);
    assertTrue(lesFourmis.get(lesFourmis.size() - 1).getEtape() instanceof Oeuf);
    int nbOeufsPondus = simulateur.getReine().getOeufsPondus();
    assertTrue(nbOeufsPondus == lesFourmis.size());
  }
  
  @Test
  void testRole() {
    Simulateur simulateur = new Simulateur();
    this.pondre(simulateur.getFourmiliere().getLeTerrain().getLesSaisons());
    assertTrue(simulateur.getFourmiliere().getLeTerrain().getLesSaisons().isPrintemps());
    List<Fourmis> lesFourmis = simulateur.getFourmiliere().getFourmis();
    int nbOeufsPondus = simulateur.getReine().getOeufsPondus();
    assertTrue(nbOeufsPondus == lesFourmis.size());
    Terrain terrain = simulateur.getLeTerrain();
    Saison saison = terrain.getLesSaisons();
    this.avancerTemps(terrain, saison);
    InformationsFourmiliere lesInfos = terrain.getInfos();
    assertNotNull(lesInfos);
    
    int nbOeufs = lesInfos.getNbOeufs();
    assertTrue(nbOeufs == 0);
    int nbLarves = lesInfos.getNbLarves();
    assertTrue(nbLarves == 0);
    int nbNymphes = lesInfos.getNbNymphes();
    assertTrue(nbNymphes == 0);
    int nbOuvriere = lesInfos.getNbOuvrieres();
    assertFalse(nbOuvriere == 0);
    int nbSoldats = lesInfos.getNbSoldats();
    assertFalse(nbSoldats == 0);
    int nbFemelle = lesInfos.getNbSexueFemelles();
    assertFalse(nbFemelle == 0);
    int nbMale = lesInfos.getNbSexueMales();
    assertFalse(nbMale == 0);
    int nbMorts = lesInfos.getNbDeMorts();
    assertTrue(nbMorts == 0);
    
    int calculNbOuvriere = 0;
    int calculNbSoldats = 0;
    int calculNbFemelle = 0;
    int calculNbMale = 0;
    for (Fourmis fourmis : lesFourmis) {
      if (fourmis.getRole() instanceof Ouvrier) {
        calculNbOuvriere++;
      } else if (fourmis.getRole() instanceof Soldat) {
        calculNbSoldats++;
      } else if (fourmis.getRole() instanceof SexueFemelle) {
        calculNbFemelle++;
      } else if (fourmis.getRole() instanceof SexueMale) {
        calculNbMale++;
      }
    }
    assertTrue(calculNbOuvriere == lesInfos.getNbOuvrieres());
    assertTrue(calculNbSoldats == lesInfos.getNbSoldats());
    assertTrue(calculNbFemelle == lesInfos.getNbSexueFemelles());
    assertTrue(calculNbMale == lesInfos.getNbSexueMales());
  }

}
