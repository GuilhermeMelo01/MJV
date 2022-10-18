package service;

import model.Contrato;
import util.FormatadorCEP;
import util.FormatadorCPF;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Notificacao {

    public void notificar(Contrato contrato) {
        StringBuilder stringBuilder = new StringBuilder();

        String nome = contrato.getCadastroCliente().getNome();
        String cpf = FormatadorCPF.formatadorCPF(contrato.getCadastroCliente().getCpf());
        Long protocolo = contrato.getProtocolo();
        String data = contrato.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String hora = contrato.getDataHora().format(DateTimeFormatter.ofPattern("HH:mm"));
        String servico = contrato.getServico().getSigla();
        BigDecimal valor = contrato.getServico().getValor();
        String cep = FormatadorCEP.formatadorCEP(contrato.getCadastroCliente().getEndereco().getCep());

        stringBuilder.append("Senhor(a) ").append(nome).append(" cpf de número ").append(cpf).append(",")
                .append(" informamos que conforme contrato com protocolo de número ").append(protocolo)
                .append("\nestá ").append("agendado para a data/hora ").append(data).append(" às ")
                .append(hora).append("h a instalação do serviço de ").append(servico).append(" com taxa de valor R$ ")
                .append(valor).append(" em sua residência localizada no endereço abaixo:\n\n")
                .append("Logradouro: ").append(contrato.getCadastroCliente().getEndereco().getLogradouro()).append(", ")
                .append(contrato.getCadastroCliente().getEndereco().getNumero()).append("\n").append("Complemento: ")
                .append(contrato.getCadastroCliente().getEndereco().getComplemento()).append("\n").append("Bairro: ")
                .append(contrato.getCadastroCliente().getEndereco().getBairro()).append("\n").append("Cidade: ")
                .append(contrato.getCadastroCliente().getEndereco().getCidade()).append("/")
                .append(contrato.getCadastroCliente().getEndereco().getUf()).append("\n").append("Cep: ").append(cep);

        System.out.println(stringBuilder);
    }
}
