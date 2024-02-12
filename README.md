# l2s4-projet-2024


# Equipe

- Julien MIROUX
- Gabrielle MAPONDA LENDO
- Annie Neilla KOBAKO
- Youssef CHAH

# Sujet

[Le sujet 2024](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2024.pdf)

# Livrables

## Livrable 1

### Atteinte des objectifs
- On a réussi à faire un algo de création aléatoire du plateau de jeu (on met des rooms et on coupe récursivement en street)

- Modélisation/affichage:Avec la classe MainFirstDeliverable on peut faire l'affichage. Quand on effectue l'affichage on arrive à distinguer les différentes types de cell (R=room,W=WasteWater,S=street,...), de plus nous affichons les doors de chaque rooms, on a reussi à associer les portes des différentes rooms.


### Difficultés restant à résoudre
- Nous avions comme idée de mieux respecter le principe d'OCP pour les spéciales rooms.

## Livrable 2

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1

- Fork du projet sur git/eclipse
- Nous avons commencé a réflechir comment nous allons representer le projet sous forme UML : Le diagramme de classe Cell a été commencée, ainsi que le diagamme de ses classes héritantes.
- Nous avons réfléchis à comment modéliser les zombies et leurs type.
- Enfin, nous avons réfléchis à l'algorythme de création (comment répartir les rues, les immeubles etc. comment spliter unn plateau de jeu stc.)
- Création d'un Trello afin de gérer la gestion du projet.

## Semaine 2

- Nous avons completé l'uml
- Nous nous sommes questionné sur le fait d'utilisé une classe pour les egout ou faire herité la classe street d'une classe street avec un egout et nous avons choisit la deuxième option.
- Nous nous sommes repartit le travail pour commencer le code
- nous avons crée des dossiers et des sous dossiers pour organiser le rangement des classes
- Nous avons une idée pour l'algorythme de division recursif que nous commencerons des cette semaine.

## Semaine 3

- Nous avons réevalué notre algorythme de création et nous avons crée la méthode display pour afficher la map.
- Nous avons eu quelques problèmes du à la compilation, nous devons régler les imports.
- Nous avons de nouvelles classe à ajouter pour notre modélisation.
- Nous allons nous répartir nos tâches sur Trello et refaire l'uml.
- Nous avons ajouté les test pour les classes concerné pour le livrable 1

## Semaine 4

- Nous avons etabli le plan pour gérer les doors et leur affichage. Nous avions réussi à faire un affichage approximatif et nous avons une idée pour l'affichage finale.
- Nous avons crée une nouvelle classe Special dont tous les objets specials room (continental, drugstore etc.) et nous avons changé le constructeur de Map afin de pouvoir ajouter une liste de room special. Ainsi, nous respecterons le principe OCP et il sera possible de créer de nouvel room speaicl et de les ajouter aléatoirement à la map.
- Nous avons également crée un enum pour gerer les différent type de room. 
- On se repartit les dernières tâches afin de finir le premier livrables. (Il y a également des test qui ont été effectués au cours de la semaine).
- On a complété le diagramme uml.
- On a changé comment on utilise les portes.
- On a fait tout les tests.
- On a supprimé des classes obslètes.
- On a ajouté les WasteWater à l'affichage.
- On a ajouté le main pour l'affichage du plateau(fonctionnel).

## Semaine 5

## Semaine 6

## Semaine 7

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
