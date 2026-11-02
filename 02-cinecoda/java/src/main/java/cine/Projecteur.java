package cine;

import java.util.Objects;

public final class Projecteur {
    private final String modele;

    public Projecteur(String modele) {
        this.modele = Objects.requireNonNull(modele, "Le modèle est obligatoire.");
    }

    public String getModele() {
        return modele;
    }
}
