package service;

import enums.TipoServico;
import model.Cadastro;
import model.Contrato;
import model.Endereco;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class DBService {
    public static void main(String[] args) {

        Contrato contrato = new Contrato();
        contrato.setServico(TipoServico.AGUA);
        contrato.setDataHora(LocalDateTime.of(2022, Month.OCTOBER,21,15,30));
        contrato.setProtocolo(2022025687L);

        Cadastro cliente = new Cadastro();
        contrato.setCadastroCliente(cliente);

        cliente.setCpf("46198146014");
        cliente.setNome("João");

        Endereco endereco = new Endereco();
        cliente.setEndereco(endereco);

        endereco.setBairro("Floresta");
        endereco.setCep("31015431");
        endereco.setCidade("Belo Horizonte");
        endereco.setUf("MG");
        endereco.setLogradouro("Rua Silveira");
        endereco.setNumero("1114");
        endereco.setComplemento("701");

        Notificacao nt = new Notificacao();
        nt.notificar(contrato);

    }
}
