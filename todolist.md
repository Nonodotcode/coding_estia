# A terminer

## Features
- [ ] Calendrier / tableau des maintenances à venir

### Ecriture dans la base
- [x] Formulaire d'ajout de machine
- [x] Formulaire création de gamme


## Mise à jour
- Changement du type de 'date_realisation' (date => text) [BDD]
*Donc changement des classes _GammeBeanModel_ et _GammeDAOModel_*

## Fichiers à implémenter
### Liste des fichiers à implémenter
#### Gestion des la session
- Nouveau fichier ***"AccueilJSPControleur"*** (contenant la gestion de la session)
- ***"SessionControleur"*** (redirection vers la page Accueil selon emploi) + "SessionControleur" doit être appelé dans le "ahref" de la navbar des Vues

#### DAO Modele
- ZoneDAOModele
- EtatDAOModele

#### Bean Modele
- ZoneBeanModele
- EtatBeanModele

#### Controleurs
- machineFormulaireControleur
- MachineAjoutControleur
- ListeOperationsControleur
- AjoutGammeControleur
- CreationGammeJSPControleur

#### Vue
- machineAjoutVue
- recapAjoutMachine
- listeOperationsVue
- creerGammeVue
- recapGammeVue

**Rajouter dans le fichier gammeVue (liste des gammes) une colonne qui redirige vers le controleur ListeOperationsControleur** => visualiser les opérations associées à une gamme
