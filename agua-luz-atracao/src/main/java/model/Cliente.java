package model;

public class Cliente {
    private String nome;
    private String cpf;
    private Contrato contrato;
    private Enderenco enderenco;

    public Cliente(String nome, String cpf, Contrato contrato, Enderenco enderenco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contrato = contrato;
        this.enderenco = enderenco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Enderenco getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(Enderenco enderenco) {
        this.enderenco = enderenco;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", contrato=").append(contrato);
        sb.append(", enderenco=").append(enderenco);
        sb.append('}');
        return sb.toString();
    }
}
