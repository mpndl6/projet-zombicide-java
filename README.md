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

### Pour compiler/executer

Il faut un junit dans le repertoire courant/principale
Pour créer l'exécutable il faut effectuer la commande :  

- make deliverable2

Pour faire la doc : 

- make doc

### Choix de la modélisation 
Pour les actor nous avons décidé de faire le choix d'une modélisation d'héritage de la sorte :
 
- Actor en classe Abstract

- Survivant héritante de Actor et Zombie héritante de Actor

Puis nous avons tous les types de survivant qui hérite de celle-ci :

- Healer,Risky,Fighter,Nosy

Et aussi tous les types de zombies héritant de Zombie :

- Abomination,Powerful,Runner,Walker


Pour les équipements nous avons décidé de faire le choix d'une modélisation d'héritage de la sorte : 
 
- Item en classe abstract

- Puis une classe Weapon héritante de Item, de même pour Utility

Pour les types d'armes elles héritents tous de Weapon :

- Axe,Carabine,Chainsaw,Crowbar,Pistol

Pour les types d'utilitaires elles héritents tous de Utility :

- FirstAidKit, IRGoogles,MasterKey,Plan,Vial


### Atteinte des objectifs

Pour tout ce qui est modélisation/développement nous avons codé(et tester) et implémenté dans le livrable2 les actors et des items

### Difficultés restant à résoudre
Ce qui nous restent à faire c'est comment utiliser la méthode use des item afin de gérer leur action.

De plus on réfléchi encore comment pouvoir affecter plusieurs rôles aux survivants.


## Livrable 3

>Ce dossier contient un ``Makefile`` qui contient les règles nécéssaires. L'exécution de la commande ```make``` dans le répectoire courent permet de :
- Créer les trois exécutables des diférents livrables (rangés dans le dossier ``/jar``)
- Générer la doc à jour (rangée dans le dossier ``/doc``)
- Compliler les classes et de créer les fichiers ```.class``` (rangés dans le dossier ``/classes``)

Après l'exécution de cette commande les exécutables seront créés ainsi que celui qui nous intéresse, le livrable 3.
>Pour exécuter le jar du livrable3, exécuter la commande : ```make test-deliverable3```.\
>Pour tester tous les tests à la fois, exécuter la commande ```make test```. 


L'uml de ce livrable se trouve dans le dossier ``uml/`` 


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
- On a changé la méthode openDoorofRoom() de map pour gérer les murs
- Creation classe exception

## Semaine 8
- Nous avons récapituler toutes les actions nécessaire pour le jeu avec leur couts et contrainte.
- On a réfléchi comment pouvoir les implémenter(Actions)
- En ce qui concerne la modélisation nous avons pensé a faire une interface pour les actions suivi de deux classes d'héritage une pour les Actions des survivants et une des actions pour les zombies.

## Semaine 9

    Nous partons sur l'idée de créer une interface Action, et cette interface est implémentée par ActionSurvivor et actionZombie 
    qui sont des classes abstraites.
    Nous décidons de crée une interface Callable pour gérer les diférents paramètres de la méthodes use des utilitaires, afin que chaque utilitaire ai la même méthode avec la même signature.
    On crée une classe exception pour gérer les sac à dos qui sont remplis
    On décide de gérer le taux de drop des zombies afin que les Balaises et les abominations ai un taux de fréquence moins élevé comparé aux autres zombies.
    Nous allons nous répartir le travail sur le gestionnaire de tâche Trello.

## Semaine 10

 Nous avons modifié les méthodes make
  - ajout exception méthode make 
- garder les callable dans les méthode make
- Création classe Game
- Création actionAttackZombie et survivors
- Ajout méthode isOPen dans map pour savoir les méthodes 
- méthode doorsbetween dans Game
- Nous ne savons toujours pas comment faire l'action search
- Modifier comment on attribue un survivant à un item


## Semaine 11

## Semaine 12
