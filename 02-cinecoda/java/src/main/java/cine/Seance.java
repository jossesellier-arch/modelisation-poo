package cine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Seance {
    private final Salle salle;
    private final SupportFilm support;
    private final LocalDate date;
    private final double tarifBase;
    private final List<Billet> billets = new ArrayList<>();

    private boolean terminee;

    Seance(Salle salle, SupportFilm support, LocalDate date, double tarifBase) {
        if (tarifBase < 0) {
            throw new IllegalArgumentException(
                "Le tarif de base ne peut pas être négatif."
            );
        }

        this.salle = Objects.requireNonNull(salle);
        this.support = Objects.requireNonNull(support);
        this.date = Objects.requireNonNull(date);
        this.tarifBase = tarifBase;
    }

    public Billet vendreBillet(TarificationBillet tarification) {
        Objects.requireNonNull(tarification, "Le type de billet est obligatoire.");

        if (terminee) {
            throw new IllegalStateException(
                "Impossible de vendre un billet : la séance est terminée."
            );
        }

        if (getPlacesRestantes() == 0) {
            throw new IllegalStateException(
                "Impossible de vendre un billet : la salle est complète."
            );
        }

        Billet billet = new Billet(tarification, tarifBase);
        billets.add(billet);
        return billet;
    }

    public double getRecette() {
        return billets.stream()
            .mapToDouble(Billet::getPrix)
            .sum();
    }

    public int getPlacesRestantes() {
        return salle.getCapacite() - billets.size();
    }

    public List<Billet> getBillets() {
        return List.copyOf(billets);
    }

    void terminer() {
        if (terminee) {
            throw new IllegalStateException("La séance est déjà terminée.");
        }

        support.enregistrerProjection();
        terminee = true;
    }

    public Salle getSalle() {
        return salle;
    }

    public SupportFilm getSupport() {
        return support;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTarifBase() {
        return tarifBase;
    }

    public boolean estTerminee() {
        return terminee;
    }
}
