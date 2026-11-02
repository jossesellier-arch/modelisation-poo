package cine;

import java.time.LocalDate;
import java.util.Objects;

public final class Salle {
    private final int numero;
    private final int capacite;
    private final Projecteur projecteur;

    private EtatSalle etat = EtatSalle.LIBRE;
    private Seance seanceEnCours;

    Salle(int numero, int capacite, Projecteur projecteur) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numéro doit être positif.");
        }
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être positive.");
        }

        this.numero = numero;
        this.capacite = capacite;
        this.projecteur = Objects.requireNonNull(projecteur);
    }

    public Seance demarrerSeance(
        SupportFilm support,
        LocalDate date,
        double tarifBase
    ) {
        Objects.requireNonNull(support, "Le support est obligatoire.");
        Objects.requireNonNull(date, "La date est obligatoire.");

        if (etat != EtatSalle.LIBRE) {
            throw new IllegalStateException(
                "Impossible de démarrer la séance : la salle n'est pas libre."
            );
        }

        if (!support.estLisiblePar(projecteur, date)) {
            throw new IllegalStateException(
                "Impossible de démarrer la séance : "
                    + support.raisonIllisibilite(projecteur, date)
            );
        }

        seanceEnCours = new Seance(this, support, date, tarifBase);
        etat = EtatSalle.EN_SEANCE;
        return seanceEnCours;
    }

    public void terminerSeance() {
        if (etat != EtatSalle.EN_SEANCE) {
            throw new IllegalStateException(
                "Impossible de terminer la séance : la salle n'est pas en séance."
            );
        }

        seanceEnCours.terminer();
        seanceEnCours = null;
        etat = EtatSalle.EN_NETTOYAGE;
    }

    public void terminerNettoyage() {
        if (etat != EtatSalle.EN_NETTOYAGE) {
            throw new IllegalStateException(
                "Impossible de terminer le nettoyage : la salle n'est pas en nettoyage."
            );
        }

        etat = EtatSalle.LIBRE;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public Projecteur getProjecteur() {
        return projecteur;
    }

    public EtatSalle getEtat() {
        return etat;
    }

    public Seance getSeanceEnCours() {
        return seanceEnCours;
    }
}
