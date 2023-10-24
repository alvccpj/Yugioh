package enumerates;

public enum Raridade {
    COMUM(0.80),
    INCOMUM(0.15),
    RARA(0.04),
    MUITO_RARA(0.008),
    EPICA(0.002);

    private final double probabilidadeDrop;

    private Raridade(double probabilidadeDrop) {
        this.probabilidadeDrop = probabilidadeDrop;
    }

    public double getProbabilidadeDrop() {
        return probabilidadeDrop;
    }
}
