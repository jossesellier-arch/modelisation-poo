package cine;

import java.util.Objects;

public abstract class Projecteur {
    private final String numeroDeSerie;

    protected Projecteur(String numeroDeSerie) {
        this.numeroDeSerie = Objects.requireNonNull(
            numeroDeSerie,
            "Le numéro de série est obligatoire."
        );
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }
}
