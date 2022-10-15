package service;

import model.Cliente;

public class CadastroService {

    public static void cadastrar(Cliente cliente){
        String nome = cliente.getNome();
        String cpf = cliente.getCpf();
        String protocolo = cliente.getContrato().getProtocolo();
        // Teste
        System.out.println("Nome: "+ nome +", cpf: "+ cpf +", protocolo: "+ protocolo);
    }
}
