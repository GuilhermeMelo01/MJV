package model;

import enums.TipoServico;

import java.time.LocalDateTime;

public class Contrato {
    private String protocolo;
    private LocalDateTime agendamento;
    private TipoServico tipoServico;

    public Contrato(String protocolo, LocalDateTime agendamento, TipoServico tipoServico) {
        this.protocolo = protocolo;
        this.agendamento = agendamento;
        this.tipoServico = tipoServico;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contrato{");
        sb.append("protocolo='").append(protocolo).append('\'');
        sb.append(", agendamento=").append(agendamento);
        sb.append(", tipoServico=").append(tipoServico);
        sb.append('}');
        return sb.toString();
    }
}
