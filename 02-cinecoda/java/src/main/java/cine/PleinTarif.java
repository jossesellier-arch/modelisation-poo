package cine;

public final class PleinTarif implements TarificationBillet {
    @Override
    public String getNom() {
        return "Plein tarif";
    }

    @Override
    public double calculerPrix(double tarifBase) {
        return tarifBase;
    }
}
