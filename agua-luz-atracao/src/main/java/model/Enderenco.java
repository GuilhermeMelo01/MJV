package model;

public class Enderenco {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String Cidade;
    private String Cep;

    public Enderenco(String logradouro, String complemento, String bairro, String cidade, String cep) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        Cidade = cidade;
        Cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enderenco{");
        sb.append("logradouro='").append(logradouro).append('\'');
        sb.append(", complemento='").append(complemento).append('\'');
        sb.append(", bairro='").append(bairro).append('\'');
        sb.append(", Cidade='").append(Cidade).append('\'');
        sb.append(", Cep='").append(Cep).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
