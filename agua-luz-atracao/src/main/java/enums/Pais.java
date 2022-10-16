package enums;

public enum Pais {

    BR("BR"),
    EUA("US"),
    FRA("FR");

    private final String sigla;

    Pais(String sigla){
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
