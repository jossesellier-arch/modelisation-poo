package cine;

import java.time.LocalDate;

public interface SupportFilm {
    Film getFilm();

    boolean estLisiblePar(Projecteur projecteur, LocalDate date);

    String raisonIllisibilite(Projecteur projecteur, LocalDate date);

    void enregistrerProjection();
}
