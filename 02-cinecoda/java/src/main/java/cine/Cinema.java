package cine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cinema {
    private final String nom;
    private final List<Salle> salles = new ArrayList<>();

    public Cinema(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire.");
        }
        this.nom = nom;
    }

    public Salle ajouterSalle(int numero, int capacite, Projecteur projecteur) {
        boolean numeroDejaUtilise = salles.stream()
            .anyMatch(salle -> salle.getNumero() == numero);

        if (numeroDejaUtilise) {
            throw new IllegalArgumentException(
                "Ce numéro de salle existe déjà dans ce cinéma."
            );
        }

        Salle salle = new Salle(numero, capacite, projecteur);
        salles.add(salle);
        return salle;
    }

    public Seance programmerSeance(
        int numeroSalle,
        SupportFilm support,
        LocalDate date,
        double tarifBase
    ) {
        Salle salle = salles.stream()
            .filter(s -> s.getNumero() == numeroSalle)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                "Le cinéma ne possède pas de salle numéro " + numeroSalle + "."
            ));

        return salle.demarrerSeance(support, date, tarifBase);
    }

    public String getNom() {
        return nom;
    }

    public List<Salle> getSalles() {
        return List.copyOf(salles);
    }
}
