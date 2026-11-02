package cine;

public final class ProjecteurArgentique extends Projecteur {
    public ProjecteurArgentique(String numeroDeSerie) {
        super(numeroDeSerie);
    }

    public void lirePellicule35mm() {
        System.out.println("Lecture d'une pellicule 35 mm.");
    }
}
