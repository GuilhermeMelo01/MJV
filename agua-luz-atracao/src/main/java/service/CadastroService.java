package service;

import model.Cliente;
import model.Contrato;

public class CadastroService {

    public static void geradorArquivoPosicional(Cliente cliente, Contrato contrato){
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
