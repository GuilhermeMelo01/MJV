package model;

import enums.Notificacao;
import enums.TipoServico;

import java.time.LocalDateTime;

public class Contrato {
    private String protocolo;
    private LocalDateTime agendamento;
    private TipoServico tipoServico;
    private Notificacao notificacao;

    public Contrato(String protocolo, LocalDateTime agendamento, TipoServico tipoServico, Notificacao notificacao) {
        this.protocolo = protocolo;
        this.agendamento = agendamento;
        this.tipoServico = tipoServico;
        this.notificacao = notificacao;
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
}
