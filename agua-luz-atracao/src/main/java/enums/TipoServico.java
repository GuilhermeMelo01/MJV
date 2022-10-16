package enums;

import java.math.BigDecimal;

public enum TipoServico {
    AGUA("A", BigDecimal.valueOf(137.21)),
    ENERGIA("L", BigDecimal.valueOf(132.15));

    private final String sigla;
    private final BigDecimal valor;

    TipoServico(String sigla, BigDecimal valor) {
        this.sigla = sigla;
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
