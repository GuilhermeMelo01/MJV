package model;

import enums.Notificacao;
import enums.TipoServico;

import java.time.LocalDateTime;

public class Contrato {
    private String protocolo;
    private LocalDateTime agendamento;
    private TipoServico tipoServico;
    private Notificacao notificacao;
    private Cliente cliente;

    public Contrato(String protocolo, LocalDateTime agendamento, TipoServico tipoServico,
                    Notificacao notificacao, Cliente cliente) {
        this.protocolo = protocolo;
        this.agendamento = agendamento;
        this.tipoServico = tipoServico;
        this.notificacao = notificacao;
        this.cliente = cliente;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public LocalDateTime getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(LocalDateTime agendamento) {
        this.agendamento = agendamento;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
