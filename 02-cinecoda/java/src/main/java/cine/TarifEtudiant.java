package cine;

public final class TarifEtudiant implements TarificationBillet {
    @Override
    public String getNom() {
        return "Étudiant";
    }

    @Override
    public double calculerPrix(double tarifBase) {
        return tarifBase * 0.75;
    }
}
