package model;

import enums.Notificacao;
import enums.TipoServico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Contrato {

    private Long protocolo;
    private LocalDateTime dataHora;
    private BigDecimal valor;
    private TipoServico servico;
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

    public TipoServico getServico() {
        return servico;
    }

    public void setServico(TipoServico servico) {
        this.servico = servico;
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
