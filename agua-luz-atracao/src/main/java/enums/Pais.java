package enums;

public enum Pais {

    BR("BR"),
    US("US"),
    FR("FR");

    private final String sigla;

    Pais(String sigla){
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
