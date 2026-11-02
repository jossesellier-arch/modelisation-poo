package cine;

import java.util.Objects;

public final class Film {
    private final String titre;
    private final int dureeMinutes;

    public Film(String titre, int dureeMinutes) {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre est obligatoire.");
        }
        if (dureeMinutes <= 0) {
            throw new IllegalArgumentException(
                "La durée doit être positive."
            );
        }

        this.titre = titre;
        this.dureeMinutes = dureeMinutes;
    }

    public String getTitre() {
        return titre;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }
}
