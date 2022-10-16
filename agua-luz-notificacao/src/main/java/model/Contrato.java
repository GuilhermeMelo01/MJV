package model;

import Enums.Notificacao;
import Enums.Servico;

import java.time.LocalDateTime;

public class Contrato {

    private Long protocolo;
    private LocalDateTime dataHora;
    private Servico sevico;
    private Endereco endereco;
    private Notificacao notificacao;
    private Cadastro cadastro;

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

    public Servico getSevico() {
        return sevico;
    }

    public void setSevico(Servico sevico) {
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

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }
}
