package cine;

import java.util.Objects;

public abstract class Projecteur {
    private final String numeroDeSerie;

    protected Projecteur(String numeroDeSerie) {
        if (numeroDeSerie == null || numeroDeSerie.isBlank()) {
            throw new IllegalArgumentException(
                "Le numéro de série est obligatoire."
            );
        }

        this.numeroDeSerie = numeroDeSerie;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }
}
