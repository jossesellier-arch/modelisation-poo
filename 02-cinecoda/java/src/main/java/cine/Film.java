package cine;

import java.util.Objects;

public final class Film {
    private final String titre;

    public Film(String titre) {
        this.titre = Objects.requireNonNull(titre, "Le titre est obligatoire.");
    }

    public String getTitre() {
        return titre;
    }
}
