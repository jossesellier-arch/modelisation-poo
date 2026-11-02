package cine;

import java.util.Objects;

public final class Salle {
    private final int numero;
    private final int capacite;
    private final Projecteur projecteur;

    private EtatSalle etat = EtatSalle.LIBRE;
    private Film filmEnCours;

    // Constructeur accessible aux classes du package cine, dont Cinema.
    Salle(int numero, int capacite, Projecteur projecteur) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Le numéro doit être positif.");
        }
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être positive.");
        }

        this.numero = numero;
        this.capacite = capacite;
        this.projecteur = Objects.requireNonNull(
            projecteur,
            "Le projecteur est obligatoire."
        );
    }

    public void demarrerSeance(Film film) {
        Objects.requireNonNull(film, "Le film est obligatoire.");

        if (etat != EtatSalle.LIBRE) {
            throw new IllegalStateException(
                "Une séance ne peut démarrer que dans une salle libre."
            );
        }

        filmEnCours = film;
        etat = EtatSalle.EN_SEANCE;
    }

    public void terminerSeance() {
        if (etat != EtatSalle.EN_SEANCE) {
            throw new IllegalStateException("La salle n'est pas en séance.");
        }

        filmEnCours = null;
        etat = EtatSalle.EN_NETTOYAGE;
    }

    public void terminerNettoyage() {
        if (etat != EtatSalle.EN_NETTOYAGE) {
            throw new IllegalStateException("La salle n'est pas en nettoyage.");
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

    public Film getFilmEnCours() {
        return filmEnCours;
    }
}
