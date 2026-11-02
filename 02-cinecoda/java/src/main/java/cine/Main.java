package cine;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Le Lumière");

        Salle salleNumerique = cinema.ajouterSalle(
            1,
            120,
            new ProjecteurNumerique("NUM-001")
        );

        Salle salleArgentique = cinema.ajouterSalle(
            2,
            80,
            new ProjecteurArgentique("ARG-001")
        );

        System.out.println(
            "Projecteur salle 1 : "
                + salleNumerique.getProjecteur().getNumeroDeSerie()
        );

        System.out.println(
            "Projecteur salle 2 : "
                + salleArgentique.getProjecteur().getNumeroDeSerie()
        );
    }
}
