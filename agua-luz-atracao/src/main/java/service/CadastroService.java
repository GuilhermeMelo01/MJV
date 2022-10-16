package service;

import model.Cliente;

import java.time.format.DateTimeFormatter;

public class CadastroService {

    public static void mensagem(Cliente cliente){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        // Teste
        System.out.println("Senhor(a) "+ cliente.getNome() +" cpf de número "+ cliente.getCpf()
                +", Informamos que conforme contrato com protocolo de número "+ cliente.getContrato().getProtocolo()
                +"\nestá agendado para a data\\hora "+ cliente.getContrato().getAgendamento().format(dtf)
                +" a instalação do serviço de Água \ncom taxa de valor R$"
                + cliente.getContrato().getTipoServico().getValor()
                + " em sua residência localizada no endereço abaixo:");
    }
}
