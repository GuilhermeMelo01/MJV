package service;

import enums.TipoServico;
import model.Contrato;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Notificacao {

    public void notificar(Contrato contrato) {
        StringBuilder stringBuilder = new StringBuilder();

        String nome = contrato.getCadastroCliente().getNome();
        String cpf = contrato.getCadastroCliente().getCpf();
        Long protocolo = contrato.getProtocolo();
        String data = contrato.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String hora = contrato.getDataHora().format(DateTimeFormatter.ofPattern("HH:mm"));
        TipoServico servico = contrato.getSevico();
        BigDecimal valor = new BigDecimal(String.valueOf(contrato.getValor()));
        String cep = contrato.getCadastroCliente().getEndereco().getCep();

        stringBuilder.append("Senhor(a) "+nome+" cpf de número , informamos que conforme contrato com protocolo de número "+protocolo+" está"+"\n");
        stringBuilder.append("agendado para a data/hora "+ data +" / "+hora+ "h a instalação do serviço de "+servico+" com taxa de valor R$ "+valor+ " em sua residência localizada no\n");
        stringBuilder.append("endereço abaixo:\n\n");
        stringBuilder.append("Logradouro:"+contrato.getCadastroCliente().getEndereco().getLogradouro()+", "+contrato.getCadastroCliente().getEndereco().getBairro()+ "\n");
        stringBuilder.append("Complemento:"+contrato.getCadastroCliente().getEndereco().getComplemento()+"\n");
        stringBuilder.append("Bairro:"+contrato.getCadastroCliente().getEndereco().getBairro()+"\n");
        stringBuilder.append("Cidade:"+contrato.getCadastroCliente().getEndereco().getCidade()+"/"+contrato.getCadastroCliente().getEndereco().getUf()+"\n");
        stringBuilder.append("Cep:"+cep);

        System.out.println(stringBuilder.toString());
    }
}
