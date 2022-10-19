package model;

public class Cliente {
    private String nome;
    private String cpf;
    private Enderenco enderenco;

    public Cliente(String nome, String cpf, Enderenco enderenco) {
        this.nome = nome;
        this.cpf = cpf;
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

    public Enderenco getEnderenco() {
        return enderenco;
    }

    public void setEnderenco(Enderenco enderenco) {
        this.enderenco = enderenco;
    }
}
