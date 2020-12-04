# Projet de Mise en pratique RPOO


#### Auteur : Alan JACOB & Lucas TANNÉ

Le but de ce projet étant la simulation de l'évolution d'une fourmilliere en graphique 2D.

----------------

Avant d'aborder les questions, voici comment est structuré notre projet : 

*  [Diagramme de classe](#diagramme-de-classe)

*  [Gestion graphique](#gestion-graphique)

Voici les différentes questions que nous avons abordées :

*  [Exercice 5-1 : Installation d’une fourmilière et trace simple](#exercice-1--installation-dune-fourmilière-et-trace-simple)

*  [Exercice 5-2 : Traces graphiques](#exercice-2--traces-graphiques)
  
*  [Exercice 5-3 : Sur la piste des fourmis](#exercice-3--sur-la-piste-des-fourmis)

*  [JavaDoc](#javadoc)

----------------

## Diagramme de classe

Ce diagramme de classe prends en compte l'attribution du rôle et des étapes d'une fourmi.
Une fourmi est liée à une fourmilière qui est elle-même liée à un terrain.

![Diagramme de classe](/Classes.png)

L'utilité des classes abstraites Role et Etape était de pouvoir implementer des fonctions et y lier différentes classes.
Ainsi la classe Etape comprends :

  * Oeuf 
  * Larve
  * Nymphe
  * Adulte
  * Mort
  
Chacunes de ces étapes possèdent une durée de vie limité, quand celle-ci est atteinte elle passe à la suivante. Sauf pour le cas de la classe mort, la référence de l'objet disparait au bout de cette durée (la fourmi est supprimée). A l'étape Adulte, un rôle lui est attribué parmis les 4 possibles :

  * Ouvrier
  * Soldat
  * Sexué Mâle
  * Sexué Femelle 
  
Celui-ci est déterminé par un tirage aléatoire, des attributs permettent de determiner les limites de probabilité de l'attribution de chacuns de ces rôles (Ces attributs sont static et pas forcément optimisés). Chacune de ces fourmis adultes possèdent une durée de vie propre à elle-même.
Chacune de ces classes possèdent 3 méthodes communes :

* **step()** : Permet de faire une avancée dans le temps (dans le cas de notre simuation il s'agit d'un jour)

* **next()** ou **mourir()** : Permet de connaître l'étape actuelle d'une fourmi. La fonction **next()** d'adulte appelle **mourir()** de Rôle.

* **renseignementInformations(...)** : Fait passer un bilan de la fourmilière à chaque avancée dans le temps, celui-ci permet l'incrementation d'attributs par les feuilles de l'attribut Etape de fourmi. Ce bilan d'information sur la fourmilière permet d'écrire dans le journal à chaque avancé dans le temps. 

----------------

## Gestion graphique

La gestion graphique ne se fait pas par un MVC, chaque élement affiché possède un attribut graphique lié au package graphicLayer, hormis la fourmi qui est gérée dans une classe dédiée à son affichage (fourmisGraphique).

Ainsi la classe VueTerrain sert essentiellement de vue auxquels on ajoute des élements de nos classes métier. On les intégre à l'affichage dans l'ordre suivant : 
  * Le terrain (la fenètre)
  * Le territoire de la fourmiliere (200 autour de la fourmilière)
  * Les phéromones (stockées dans un tableau de 400 par 400)
  * Les proies (qui se génère en fonction de la population de la fourmillière)
  * Les fourmis

Les fourmis ne sont pas visible si elle se trouve au niveau de la foumilière afin de donner l'impression de rentrer au sein de celle-ci.
L'implémentation graphique avance de la même durée dans les 3 exercices (un jour).

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
Grâce à l'évolution de la fourmi de Nymphe à Adulte, la fourmi est dotée d'un attribut FourmisGraphique, qui est ajouté sur le terrain afin de pouvoir simuler la fourmi sur le terrain. Celle-ci est placée au centre de la fourmilliere et n'est pas visible tant qu'elle se trouve dans la fourmilière.

*On demande de tracer graphiquement ledéplacement des fourmis. Déplacement aléatoire pur : Représentez la fourmilière par un carré et chaquefourmi par un point. On doit pouvoir visualiser un nuage de points dont l’évolution est complètementaléatoire. La seule contrainte qui gère le déplacement est qu’une fourmi ne sort jamais de son territoire.*

**Gestion du cas**

* Les fourmis sont donc caractérisées par des ronds bleus, se déplaçant de manière totalement aléatoire, ayant 25% de chance de se déplacer sur les axes des abscisse et ordonnée (positif et négatif) par rapport à elle (étant l'origine de ces axes). Le pas d'incrémentation ou de décrementation du déplacement de la fourmi est fixé par une variable globale. Cette fourmi peut sortir de 1 case de son territoire, à partir de ce moment elle réfléchit à faire demi-tour et revenir vers sa fourmiliere. Au survol de la fourmilière ces dernières deviennent invisible, simulant leur entrée dans la fourmiliere. Si ces dernières meurs en dehors de la fourmilière et dans leur territoire elle se colorent en jaune et disparaissent 5 pas dans le temps plus tard.

*Les proies : Représentez le déplacement aléatoire de proies qui entrent et qui sortent du territoirevisualisé*

**Gestion du cas** 

* La gestion des prois est quasi-similaire à celle des fourmis, la différence est que ces dernières apparaissent aléatoirement sur le terrain et ne sont pas limitées à un territoire. Si elle dépasse le cadre du terrain visualisable, ces dernières sont supprimées graphiquement et déférencées. Leur deplacement sont aléatoire et ont autant de chance de se déplacer dans les 4 directions possibles (Haut, Bas, Droite, Gauche). Les proies sont représentées graphiquement par des carrées blancs.

----------------
**Trace d'éxecution graphique**

De la création à la mort de la fourmilière :

![GIF du cube](/exo52.gif)

**Légende :**
* Blanc : Les proies
* Bleu : Fourmis Adultes
* Jaune : Fourmis Mortes
* Rouge : Fourmilière
* Rectangle blanc : Territoire de la fourmilière

----------------

## Exercice 3 : Sur la piste des fourmis

**La Chasse et le stock de nourriture**

* Quand une fourmi se trouve au même endroit qu'une proie, elle la tue et ramène directement à la fourmilière, sur la simulation on voit la proie disparaître (car elle est morte), la fourmi passe de la couleur bleu à la couleur magenta puis se déplace en direction de la fourmilière.
Quand une fourmi rentre à la fourmilière, elle augmente de 1 le stock de nourriture.
Une trace de cette augmentation a été ajouté au journal, on peut donc suivre l'état des stocks de nourriture au fur et à mesure de la simulation.
Une fois la fourmi dans la fourmilière, elle repasse en couleur bleu et repart à la recherche d'une nouvelle proie.

**Les phéromones**

* Au passage sur une case, les fourmis déposent des phéromones permettant de suivre la trace de celle-ci. Si l'endroit où elle se situe n'est pas marqué par une phéromone alors elle y ajoute une phéromone avec une intensité maximale, cette dernière se décrementant tout les 10 steps. Ainsi, une trainée est dessinée derrière la proie afin de pouvoir guider d'autres fourmis, celle-ci change de couleur afin de pouvoir distinguer la faible intensité. Dans le cas, où l'intensité est de 0, la case de phéromones devient invisble et attends une nouveau passage pour s'activer. Les fourmis recherchent dans les quatres directions de déplacement possible (haut, bas, droit, gauche) si il y a existence de phéromones afin de modifier dynamiquement la probabilité de chance de s'y rendre. 
Cette tâche est extrement lourde sachant que 1600 (80×80) cases de phéromones sont vérifiés à chaque steps, puis traiter l'information en fonction de chaque fourmis (incrémentation, etc...). Ainsi, plus il y a de fourmi, plus nous avons du mal a gérer les phéromones, les trainées deviennent de plus en plus petite en fonction du nombre de fourmies créées.

----------------
**Trace d'éxecution graphique**

![GIF du cube](/exo53.png)

**Légende :**
* Blanc / Contour rouge : Les proies
* Bleu : Fourmis adultes
* Rouge : Fourmilière
* Magenta : Fourmis ramenant une proie à la fourmilière
* Rectangle blanc : Territoire de la fourmilière


## Javadoc

Chaque exercice est complété de sa JavaDoc afin d'aider à la compréhension du code. Disponible dans les répertoire Doc des branches correpondantes à chaque exercice.

