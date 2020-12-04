# Projet de Mise en pratique RPOO


#### Auteur : Alan JACOB & Lucas TANNÉ

Le but de ce projet étant la simulation de l'évolution d'une fourmilliere en graphique 2D.

----------------





Voici les différentes questions que nous avons abordé:

*  [Exercice 5-1 : Installation d’une fourmilière et trace simple](#exercice-1--installation-dune-fourmilière-et-trace-simple)

*  [Exercice 5-2 : Traces graphiques](#exercice-2--traces-graphiques)
  
*  [Exercice 5-3 : Sur la piste des fourmis](#exercice-3--sur-la-piste-des-fourmis)

*  [JavaDoc](#javadoc)





![GIF du cube](/Classes.png)


----------------

## Exercice 1 : Installation d’une fourmilière et trace simple

*La simulation débute avec la nidification d’une reine.*
**Gestion du cas**

*  Création d'une Reine, cette dernière créer une fourmiliere grâce à la méthode creerFourmiliere.

 *Elle s’installe et pond.*  
 
**Gestion du cas**
*  Elle est installée dans sa fourmilière et commence à pondre au début du printemps (jour 80 de la simulation modulo 365), sa portée comprends entre 1 et 3 oeuf chaque jour jusqu'au début de l'été (jour 172 de la simulation modulo 365). Pour devenir un adulte, il faut 25 jours à partir de la ponte. Chaque rôle est attribué de façon aléatoire via un tirage au sort d'un nombre compris entre 0 et 100. De plus chaque fourmis est vouée à mourir entre 547 et 913 jours.

*La simulation met en oeuvre l’évolution de la fourmilière jusqu’à ce qu’il ne reste plus de nymphe.*

**Gestion du cas**
* La simulation prends fin quand la reine décède (celle-ci ayant pour espérance de vie comprise entre 1461 et 3652 jours), amenant à la mort de tout les habitants de la fourmilière ensuite.

*Il est tout d’abord demandé de produire des traces alphanumériques permettant de suivre dans letemps, l’évolution de la fourmilière. Cette trace comportera, par exemple, le nombre d’oeufs, de larves,de nymphes et de fourmis (ouvrières, soldats et individus sexués).*

**Gestion du cas**
* Nous avons mis en place une classe Journal qui écris dans un fichier texte à chaque step (avancée dans le temps) effectuée. Ainsi on peut y voir l'evolution de la foumilière, plus précisement:
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
    * De mort

----------------
**Trace d'éxecution**

Jour n°687
Population : 279
Informations sur la fourmilière :
- Nombre d'oeufs : 0
- Nombre de larves : 0
- Nombre de nymphes : 0
- Nombre d'ouvrières : 180
- Nombre de soldats : 62
- Nombre de femelles : 19
- Nombre de mâles : 18
- Nombre de morts : 0

Jour n°688
Population : 279
Informations sur la fourmilière :
- Nombre d'oeufs : 0
- Nombre de larves : 0
- Nombre de nymphes : 0
- Nombre d'ouvrières : 180
- Nombre de soldats : 62
- Nombre de femelles : 18
- Nombre de mâles : 18
- Nombre de morts : 1

----------------

## Exercice 2 : Traces graphiques

*Les fourmis sortent de la fourmilière dès la fin de leur formation.*

**Gestion du cas**

* Un terrain est mise en place graphiquement via le package graphicLayer, à sa création la fourmilière est ainsi implémenté sur ce terrain par un carré rouge.
Grâce à l'évolution de la fourmis de Nymphe à Adulte, la fourmis est dotée d'un attribut FourmisGraphique, qui est ajouté sur le terrain afin de pouvoir simuler la fourmis sur le terrain. Celle-ci est placée au centre de la fourmilliere et n'est pas visible tant qu'elle se trouve dans la fourmilière.

*On demande de tracer graphiquement ledéplacement des fourmis. Déplacement aléatoire pur : Représentez la fourmilière par un carré et chaquefourmi par un point. On doit pouvoir visualiser un nuage de points dont l’évolution est complètementaléatoire. La seule contrainte qui gère le déplacement est qu’une fourmi ne sort jamais de son territoire.*

**Gestion du cas**
* Les fourmis sont donc caractérisées par des ronds bleus, se déplaçant de manière totalement aléatoire, ayant 25% de chance de se déplacer sur les axes des abscisse et ordonnée (positif et négatif) par rapport à elle (étant l'origine de ces axes). Le pas d'incrémentation ou de décrementation du déplacement de la fourmis est fixé par une variable globale. Cette fourmis peut sortir de 1 case de son territoire, à partir de ce moment elle réfléchit à faire demi-tour et revenir vers sa fourmiliere. Au survol de la fourmilière ces dernières deviennent invisible, simulant leur entrée dans la fourmiliere. Si ces dernières meurs en dehors de la fourmilière et dans leur territoire elle se colorent en jaune et disparaissent 5 pas dans le temps plus tard.

*Les proies : Représentez le déplacement aléatoire de proies qui entrent et qui sortent du territoirevisualisé*

**Gestion du cas** 
* La gestion des prois est quasi-similaire à celle des fourmis, la différence est que ces dernières apparaissent aléatoirement sur le terrain et ne sont pas limitées à un territoire. Si elle dépasse le cadre du terrain visualisable, ces dernières sont supprimées graphiquement et déférencées. Leur deplacement sont aléatoire et ont autant de chance de se déplacer dans les 4 directions possibles (Haut, Bas, Droite, Gauche). Les proies sont représentées graphiquement par des carrées blancs.

----------------
**Trace d'éxecution graphique**
De la création à la mort de la fourmilière :

![GIF du cube](/exo52.gif)

----------------

## Exercice 3 : Sur la piste des fourmis

...

## Javadoc

Chaque exercice est complété de sa JavaDoc afin d'aider à la compréhension du code. Disponible dans les répertoire Doc des branches correpondantes à chaque exercice.

