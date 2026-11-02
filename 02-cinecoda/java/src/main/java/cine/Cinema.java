package cine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cinema {
    private final String nom;
    private final List<Salle> salles = new ArrayList<>();

    public Cinema(String nom) {
        this.nom = Objects.requireNonNull(nom, "Le nom est obligatoire.");
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

    public String getNom() {
        return nom;
    }

    public List<Salle> getSalles() {
        return List.copyOf(salles);
    }
}
