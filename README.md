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

Après avoir compiler à l'aide d'un ide tel que eclipse, intelliJ etc. ou avec les commandes du shell Il sera possible de créer l'archive exécutable.
Pour créer l'archive exécutable du premier livrable, il faudra se placer dans le repectoire racine (l2s4 ../) et effectuer la commande suivante :
```
% jar cvfe deliverable1.jar zombicide.map.MainFirstDeliverable -C classes zombicide
```
Et pour l'exécuter :

```
% java -jar deliverable1.jar
```
### Atteinte des objectifs
- On a réussi à faire un algo de création aléatoire du plateau de jeu (on met des rooms et on coupe récursivement en street)

- Modélisation/affichage: avec la classe MainFirstDeliverable on peut faire l'affichage. Quand on effectue l'affichage on arrive à distinguer les différentes types de cell (R=room,W=WasteWater,S=street,...), de plus nous affichons les doors de chaque rooms, on a reussi à associer les portes des différentes rooms.


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

- Nous avons réflechi à la conception de l'uml pour la livrable 2(Modélisation actors et equipment).

- On a décidé de mettre les classes : survivors/weapons/item en classe abstraite

- On a rélechi aux méthodes pour les classes survivors et weapons

- On a essayé de voir comment attribuer plusieurs rôles aux survivors avec l'héritage.
## Semaine 6

- On a refait le diagramme UML. Nous décidons de créer un objet backpack pour gérer les sac à dos des survivors.

- Nous ne savons pas comment gérer la méthode use de weapon.

- Nous hésitons à mettre un attributs survivors dans les items pour pouvoir récupérer les différents méthodes.

- On s'est dispersé les différentes tâches à faire(Sur l'application Trello,application gestion des tâches).

- On ne sait pas encore comment utiliser la façon de gérer les attaques des zombies et des survivors

- On va commit le diagramme UML sur le gitlab

## Semaine 7
- création du livrable 2: on a fait la map entrainement sur laquelle nous avons placés les survivants avec une fiole dans la main et une carte dans le backpack. De plus, nous déplaçons les survivants vers le nord .
- changement de la méthode increaseXP(nous augmentons les points d'actions directement dedans)
- Nous avons effectués les tests des nouvelles classes 
- ajout de la description des cellules 
- ajout d'un tostring pour les survivors pour savoirs ce qu'ils ont sur eux 

## Semaine 8

## Semaine 9

## Semaine 10

## Semaine 11

## Semaine 12
