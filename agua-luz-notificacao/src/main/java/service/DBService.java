package service;

import enums.TipoServico;
import model.Cadastro;
import model.Contrato;
import model.Endereco;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DBService {
    public static void main(String[] args) {

        Contrato contrato = new Contrato();
        contrato.setSevico(TipoServico.AGUA);
        contrato.setValor(new BigDecimal(127.33));
        contrato.setDataHora(LocalDateTime.now());
        contrato.setProtocolo(2022025687L);

        Cadastro cliente = new Cadastro();
        contrato.setCadastroCliente(cliente);

        cliente.setCpf("3396371623");
        cliente.setNome("João");

        Endereco endereco = new Endereco();
        cliente.setEndereco(endereco);

        endereco.setBairro("Floresta");
        endereco.setCep("31015-431");
        endereco.setCidade("Belo Horizonte");
        endereco.setUf("MG");
        endereco.setLogradouro("Rua Silveira");
        endereco.setComplemento("374");

        Notificacao nt = new Notificacao();
        nt.notificar(contrato);

    }
}
