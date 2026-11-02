package cine;

import java.time.LocalDate;
import java.util.Objects;

public final class Copie35mm implements SupportFilm {
    private static final int MAX_PROJECTIONS = 50;

    private final Film film;
    private int nombreProjections;

    public Copie35mm(Film film) {
        this.film = Objects.requireNonNull(film);
    }

    @Override
    public Film getFilm() {
        return film;
    }

    @Override
    public boolean estLisiblePar(Projecteur projecteur, LocalDate date) {
        return projecteur instanceof ProjecteurArgentique
            && nombreProjections < MAX_PROJECTIONS;
    }

    @Override
    public String raisonIllisibilite(Projecteur projecteur, LocalDate date) {
        if (!(projecteur instanceof ProjecteurArgentique)) {
            return "La copie 35 mm nécessite un projecteur argentique.";
        }
        if (nombreProjections >= MAX_PROJECTIONS) {
            return "La copie 35 mm a atteint sa limite de "
                + MAX_PROJECTIONS + " projections.";
        }
        return "";
    }

    @Override
    public void enregistrerProjection() {
        if (nombreProjections >= MAX_PROJECTIONS) {
            throw new IllegalStateException(
                "La copie 35 mm ne peut plus être projetée."
            );
        }
        nombreProjections++;
    }

    public int getNombreProjections() {
        return nombreProjections;
    }
}
