package cine;

public final class Billet {
    private final TarificationBillet tarification;
    private final double prix;

    Billet(TarificationBillet tarification, double tarifBase) {
        this.tarification = tarification;
        this.prix = tarification.calculerPrix(tarifBase);
    }

    public String getType() {
        return tarification.getNom();
    }

    public double getPrix() {
        return prix;
    }
}
