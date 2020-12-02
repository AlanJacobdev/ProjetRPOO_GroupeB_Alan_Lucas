package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import environnement.Simulateur;
import fourmiliere.Adulte;
import fourmiliere.Fourmiliere;
import fourmiliere.Fourmis;
import fourmiliere.Larve;
import fourmiliere.Nymphe;
import fourmiliere.Oeuf;
import fourmiliere.Terrain;

class testFourmiliere {
  
  private void oeufToLarve(Fourmis fourmis) {
    for (int i = 0; i < 3; i++) {
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
  void testFourmiliere() {
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
    
  }

}
