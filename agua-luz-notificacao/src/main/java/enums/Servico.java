package enums;

import java.math.BigDecimal;

public enum Servico {

    AGUA("Água", BigDecimal.valueOf(137.21)),
    LUZ("Luz", BigDecimal.valueOf(132.15));

    private final String nome;
    private final BigDecimal valor;

    Servico(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
