package model;

import enums.Notificacao;
import enums.TipoServico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Contrato {

    private Long protocolo;
    private LocalDateTime dataHora;
    private BigDecimal valor;
    private TipoServico sevico;
    private Endereco endereco;
    private Notificacao notificacao;
    private Cadastro cadastroCliente;

    public Long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Long protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoServico getSevico() {
        return sevico;
    }

    public void setSevico(TipoServico sevico) {
        this.sevico = sevico;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public Cadastro getCadastroCliente() {
        return cadastroCliente;
    }

    public void setCadastroCliente(Cadastro cadastroCliente) {
        this.cadastroCliente = cadastroCliente;
    }
}
