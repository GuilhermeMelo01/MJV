package model;

public class Cadastro {
    private Cliente cliente;
    private Contrato contrato;

    public Cadastro(Cliente cliente, Contrato contrato) {
        this.cliente = cliente;
        this.contrato = contrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cadastro{");
        sb.append("cliente=").append(cliente);
        sb.append(", contrato=").append(contrato);
        sb.append('}');
        return sb.toString();
    }
}
