package cine;

import java.time.LocalDate;
import java.util.Objects;

public final class Dcp implements SupportFilm {
    private final Film film;
    private final LocalDate dateExpirationCle;

    public Dcp(Film film, LocalDate dateExpirationCle) {
        this.film = Objects.requireNonNull(film);
        this.dateExpirationCle = Objects.requireNonNull(dateExpirationCle);
    }

    @Override
    public Film getFilm() {
        return film;
    }

    @Override
    public boolean estLisiblePar(Projecteur projecteur, LocalDate date) {
        return projecteur instanceof ProjecteurNumerique
            && !date.isAfter(dateExpirationCle);
    }

    @Override
    public String raisonIllisibilite(Projecteur projecteur, LocalDate date) {
        if (!(projecteur instanceof ProjecteurNumerique)) {
            return "Le DCP nécessite un projecteur numérique.";
        }
        if (date.isAfter(dateExpirationCle)) {
            return "La clé de lecture a expiré le "
                + dateExpirationCle + ".";
        }
        return "";
    }

    @Override
    public void enregistrerProjection() {
        // Une projection ne consomme pas le DCP.
    }
}
