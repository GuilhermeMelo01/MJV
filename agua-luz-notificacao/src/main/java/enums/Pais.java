package enums;

public enum Pais {

    BRASIL("BR"),
    ESTADOS_UNIDOS("US"),
    FRANCA("FR");

    private final String sigla;

    Pais(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
