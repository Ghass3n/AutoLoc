# Atelier 3 : notes sur la couche Repository

## Choix d'interface

Toutes les interfaces étendent `JpaRepository<Entité, Long>`, car elle cumule le CRUD,
les méthodes qui renvoient des `List`, le tri, la pagination et les méthodes propres à JPA
(`flush`, `saveAndFlush`, `getReferenceById`).

| Interface | Étend | Justification |
|---|---|---|
| IAgenceRepository | JpaRepository<Agence, Long> | CRUD complet, `findAll` renvoie une `List`, `saveAndFlush` disponible. |
| IEmployeRepository | JpaRepository<Employe, Long> | Idem. |
| IVehiculeRepository | JpaRepository<Vehicule, Long> | Idem, tri et pagination utiles pour le catalogue de véhicules. |
| IEquipementRepository | JpaRepository<Equipement, Long> | Idem. |
| IClientRepository | JpaRepository<Client, Long> | Idem. |
| IReservationRepository | JpaRepository<Reservation, Long> | Idem. |
| IContratRepository | JpaRepository<Contrat, Long> | Idem. Créée d'abord avec `CrudRepository`, puis passée à `JpaRepository`. |
| IPaiementRepository | JpaRepository<Paiement, Long> | Créée pour lire les paiements. Le code métier crée ou retire un paiement via le Contrat (composition). |
| IMaintenanceRepository | JpaRepository<Maintenance, Long> | Idem. |

Limite à retenir : `deleteAllInBatch` et `deleteAllByIdInBatch` contournent le contexte de
persistance, donc la cascade et l'`orphanRemoval` ne s'appliquent pas. Sur des contrats, ils
laisseraient des paiements orphelins ou échoueraient sur la clé étrangère.

## Analyse SonarQube for IDE

Analyse lancée sur l'ensemble du projet : aucune anomalie détectée
(0 issue, 0 security hotspot, 0 taint vulnerability).

| Anomalie SonarQube for IDE | Règle / explication | Correction apportée |
|---|---|---|
| Aucune | Aucune anomalie relevée par l'analyse du projet complet. | Sans objet. |