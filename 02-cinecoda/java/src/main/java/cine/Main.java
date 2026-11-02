package cine;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Le Lumière");

        Salle salle = cinema.ajouterSalle(
            1,
            120,
            new Projecteur("Laser 4K")
        );

        Film film = new Film("Les Étoiles");

        salle.demarrerSeance(film);
        salle.terminerSeance();     // Passe en nettoyage
        salle.terminerNettoyage();  // Redevient libre

        System.out.println("Cinéma : " + cinema.getNom());
        System.out.println("Salle : " + salle.getNumero());
        System.out.println("État : " + salle.getEtat());
    }
}
