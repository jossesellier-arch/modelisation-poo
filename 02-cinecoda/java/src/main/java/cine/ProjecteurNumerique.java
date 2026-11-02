package cine;

public final class ProjecteurNumerique extends Projecteur {
    public ProjecteurNumerique(String numeroDeSerie) {
        super(numeroDeSerie);
    }

    public void lireFichierNumerique(String nomFichier) {
        if (nomFichier == null || nomFichier.isBlank()) {
            throw new IllegalArgumentException("Le nom du fichier est obligatoire.");
        }

        System.out.println("Lecture du fichier numérique : " + nomFichier);
    }
}

