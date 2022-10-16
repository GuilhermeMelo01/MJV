package service;

import model.Cadastro;
import model.Cliente;
import model.Contrato;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CadastroService {

    public static Cadastro realizarCadastro(Cliente cliente, Contrato contrato){
        return new Cadastro(cliente, contrato);
    }

    public static void mensagem(Cliente cliente, Contrato contrato){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        // Teste
        System.out.println("Senhor(a) "+ cliente.getNome() +" cpf de número "+ cliente.getCpf()
                +", Informamos que conforme contrato com protocolo de número "+ contrato.getProtocolo()
                +"\nestá agendado para a data\\hora "+ contrato.getAgendamento().format(dtf)
                +" a instalação do serviço de Água \ncom taxa de valor R$"
                + contrato.getTipoServico().getValor()
                + " em sua residência localizada no endereço abaixo:");
    }

    public static void geradorArquivoPosicional(Cadastro cadastro){
        Cliente cliente = cadastro.getCliente();
        Contrato contrato = cadastro.getContrato();
        StringBuilder sb = new StringBuilder();

        String cpf = cliente.getCpf();
        cpf = cpf.replaceAll("\\.", "");

        String nome = cliente.getNome();
        int minNome = Math.min(30, nome.length());
        nome = nome.substring(0, minNome).toUpperCase();

        String logradouro = cliente.getEnderenco().getLogradouro();
        int minLogradouro = Math.min(20, logradouro.length());
        logradouro = logradouro.substring(0, minLogradouro).toUpperCase();

        String complemento = cliente.getEnderenco().getComplemento();
        int minComplemento = Math.min(10, complemento.length());
        complemento = complemento.substring(0, minComplemento).replaceAll(",", "").toUpperCase();

        String bairro = cliente.getEnderenco().getBairro();
        int minBairro = Math.min(15, bairro.length());
        bairro = bairro.substring(0, minBairro).toUpperCase();






    }
}
