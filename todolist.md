# A terminer
- [ ] CSS
- [ ] Finaliser le câblage des pages entre elles
- [ ] Vérification ultime

## Features
- [ ] Calendrier / tableau des maintenances à venir

### Ecriture dans la base
- [x] Formulaire d'ajout de machine
- [x] Formulaire création de gamme


## Mise à jour
- [x] Changement du type de 'date_realisation' (date => text) [BDD]
- [x] *Donc changement des classes _GammeBeanModel_ et _GammeDAOModel_*

## Fichiers à implémenter
### Liste des fichiers à implémenter
#### Gestion des la session
- [x] Nouveau fichier ***"AccueilJSPControleur"*** (contenant la gestion de la session)
- [x] ***"SessionControleur"*** (redirection vers la page Accueil selon emploi) + "SessionControleur" doit être appelé dans le "ahref" de la navbar des Vues

#### DAO Modele
- [x] ZoneDAOModele
- [x] EtatDAOModele

#### Bean Modele
- [x] ZoneBeanModele
- [x] EtatBeanModele

#### Controleurs
- [x] machineFormulaireControleur
- [x] MachineAjoutControleur

- [x] ListeOperationsControleur
- [ ] AjoutGammeControleur
- [ ] CreationGammeJSPControleur

#### Vue
- [x] machineAjoutVue
- [x] recapAjoutMachine
- [x] listeOperationsVue
- [ ] creerGammeVue
- [ ] recapGammeVue

- [x] **Rajouter dans le fichier gammeVue (liste des gammes) une colonne qui redirige vers le controleur ListeOperationsControleur** => visualiser les opérations associées à une gamme
