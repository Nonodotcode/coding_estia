# A terminer

## Features
- Calendrier / tableau des maintenances à venir

### Ecriture dans la base
- [x] Formulaire d'ajout de machine
- [ ] Formulaire création de gamme
- [ ] Formulaire création/modif d'opération

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

#### Vue
- machineAjoutVue
- recapAjoutMachine
