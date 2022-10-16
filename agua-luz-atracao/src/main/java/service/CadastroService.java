package service;

import model.Cadastro;
import model.Cliente;
import model.Contrato;

import java.time.format.DateTimeFormatter;

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

    public static void geradorArquivoPosicional(){

    }
}
