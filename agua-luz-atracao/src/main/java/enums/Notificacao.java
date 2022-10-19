package enums;

public enum Notificacao {

    SMS("S"),
    WHATSAPP("W");

    private final String sigla;

    Notificacao(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
