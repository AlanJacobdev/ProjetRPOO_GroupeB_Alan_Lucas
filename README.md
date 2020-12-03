# Projet de Mise en pratique RPOO


#### Auteur : Alan JACOB & Lucas TANNÉ

Le but de ce projet étant le développement d’un langage spécifique pour des animations graphiques simples 

----------------

Le projet est découpé en **5 exercices** majeurs déclinés en plusieurs mineurs:

*  [Exercice 5-1 : Installation d’une fourmilière et trace simple](#exercice-1--installation-dune-fourmilière-et-trace-simple)

*  [Exercice 5-2 : Traces graphiques](#exercice-2--traces-graphiques)
  
*  [Exercice 5-3 : Sur la piste des fourmis](#exercice-3--sur-la-piste-des-fourmis)


----------------

## Exercice 1 : Installation d’une fourmilière et trace simple

*La simulation débute avec la nidification d’une reine.*
**Gestion du cas**
*  Création d'une Reine, cette dernière créée une fourmiliere grace à la méthode creerFourmiliere.

 *Elle s’installe et pond.*
**Gestion du cas**
*  Elle est installée dans sa fourmilière et commence à pondre au début du printemps (jour 80 de la simulation modulo 365), sa portée comprends entre 1 et 3 oeuf chaque jour jusqu'au début de l'été (jour 172 de la simulation modulo 365). Pour devenir un adulte un oeuf est de 25 jours à partir de la ponte. Chaque role est attribué de façon aléatoire via un tirage au sort d'un nombre compris entre 0 et 100. 

*La simulation met enoeuvre l’évolution de la fourmilière jusqu’à ce qu’il ne reste plus de nymphe.*
**Gestion du cas**
* La simulation prends fin quand la reine décède, amenant à la mort de tout les habitants de la fourmilière ensuite.

*Il est tout d’abord demandé de produire des traces alphanumériques permettant de suivre dans letemps, l’évolution de la fourmilière. Cette trace comportera, par exemple, le nombre d’oeufs, de larves,de nymphes et de fourmis (ouvrières, soldats et individus sexués).*
**Gestion du cas**
* Nous avons mis en place une classe Journal qui écris dans un fichier texte à chaque step (avancé dans le temps) effectué. Ainsi on peut y voir l'evolution de la foumilière, plus précisement:
  * Le jour actuel
  * La taille de la population de fourmis vivante
  * Le nombres :
    * D'oeuf
    * De larves 
    * De nymphes
    * D'ouvrieres
    * De soldats
    * De sexuées femelles
    * De sexués mâles
    * De Mort

----------------

## Exercice 2 : Traces graphiques

**Aucuns problèmes rencontrés**

Mise en place d'un cube circulant sur les bords de la fenêtre tout en changeant de couleur (*adaptation responsive*).


![GIF du cube](/cube.gif)


----------------
----------------

## Exercice 1 : Sur la piste des fourmis

**Aucuns problèmes rencontrés**

Mise en place d'un cube circulant sur les bords de la fenêtre tout en changeant de couleur (*adaptation responsive*).


![GIF du cube](/cube.gif)


----------------



