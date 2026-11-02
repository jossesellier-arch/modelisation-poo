package cine;

public final class TarifEnfant implements TarificationBillet {
    @Override
    public String getNom() {
        return "Enfant";
    }

    @Override
    public double calculerPrix(double tarifBase) {
        return 5.0;
    }
}
