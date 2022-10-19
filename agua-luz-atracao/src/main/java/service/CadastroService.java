package service;

import model.Contrato;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CadastroService {

    public static void geradorArquivoPosicional(Contrato contrato) throws IOException {
        StringBuilder sb = new StringBuilder();

        String cpf = contrato.getCliente().getCpf();
        int minCpf = Math.min(11, cpf.length());
        while (minCpf < 11) {
            cpf = cpf.concat("#");
            minCpf++;
        }
        cpf = cpf.replaceAll("\\.", "");

        String nome = contrato.getCliente().getNome();
        int minNome = Math.min(30, nome.length());
        while (minNome <= 30) {
            nome = nome.concat("#");
            minNome++;
        }
        nome = nome.substring(0, minNome).toUpperCase();

        String logradouro = contrato.getCliente().getEnderenco().getLogradouro();
        int minLogradouro = Math.min(20, logradouro.length());
        while (minLogradouro < 20) {
            logradouro = logradouro.concat("#");
            minLogradouro++;
        }
        logradouro = logradouro.substring(0, minLogradouro).toUpperCase();

        String complemento = contrato.getCliente().getEnderenco().getComplemento();
        int minComplemento = Math.min(10, complemento.length());
        while (minComplemento < 10) {
            complemento = complemento.concat("#");
            minComplemento++;
        }
        complemento = complemento.substring(0, minComplemento).replaceAll(",", "").toUpperCase();

        String bairro = contrato.getCliente().getEnderenco().getBairro();
        int minBairro = Math.min(15, bairro.length());
        while (minBairro < 15) {
            bairro = bairro.concat("#");
            minBairro++;
        }
        bairro = bairro.substring(0, minBairro).toUpperCase();

        String cidade = contrato.getCliente().getEnderenco().getCidade().toUpperCase();
        int minCidade = Math.min(30, cidade.length());
        while (minCidade < 30) {
            cidade = cidade.concat("#");
            minCidade++;
        }
        cidade = cidade.substring(0, minCidade);

        String uf = contrato.getCliente().getEnderenco().getUf().toUpperCase();
        int minUf = Math.min(2, uf.length());
        while (minUf < 2) {
            uf = uf.concat("#");
            minUf++;
        }
        uf = uf.substring(0, minUf);

        String cep = contrato.getCliente().getEnderenco().getCep().replaceAll("\\.", "");
        int minCep = Math.min(8, cep.length());
        while (minCep < 8) {
            cep = cep.concat("#");
            minCep++;
        }
        cep = cep.substring(0, minCep);

        String siglaPais = contrato.getCliente().getEnderenco().getPais().getSigla();

        long longProtocolo = Long.parseLong(contrato.getProtocolo());
        String protocolo = String.format("%010d", longProtocolo);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        String dataFormatada = contrato.getAgendamento().toLocalDate().format(df);
        dataFormatada = dataFormatada.replaceAll("/", "");

        String horaFormatada = contrato.getAgendamento().toLocalTime().toString();
        int minHora = Math.min(5, horaFormatada.length());
        horaFormatada = horaFormatada.substring(0, minHora).replaceAll(":", "");

        String siglaTipoServico = contrato.getTipoServico().getSigla();

        String valorTipoServico = contrato.getTipoServico().getValor().toString();
        valorTipoServico = valorTipoServico.replaceAll("\\.", "");
        valorTipoServico = "000".concat(valorTipoServico);

        String siglaNotificacao = contrato.getNotificacao().getSigla();

        sb.append(cpf).append(nome).append(logradouro).append(complemento).append(bairro)
                .append(cidade).append(uf).append(cep).append(siglaPais).append(protocolo)
                .append(dataFormatada).append(horaFormatada).append(siglaTipoServico)
                .append(valorTipoServico).append(siglaNotificacao).append("*\n");

        System.out.println(sb);

        criarArquivo(sb, "txt");
    }

    public static void geradorArquivoCSV(Contrato contrato) throws IOException {
        StringBuilder sb = new StringBuilder();

        String cpf = contrato.getCliente().getCpf();
        int minCpf = Math.min(11, cpf.length());
        cpf = cpf.replaceAll("\\.", "");

        String nome = contrato.getCliente().getNome();
        int minNome = Math.min(30, nome.length());
        nome = nome.substring(0, minNome).toUpperCase();

        String logradouro = contrato.getCliente().getEnderenco().getLogradouro();
        int minLogradouro = Math.min(20, logradouro.length());
        logradouro = logradouro.substring(0, minLogradouro).toUpperCase();

        String complemento = contrato.getCliente().getEnderenco().getComplemento();
        int minComplemento = Math.min(10, complemento.length());
        complemento = complemento.substring(0, minComplemento).replaceAll(",", "").toUpperCase();

        String bairro = contrato.getCliente().getEnderenco().getBairro();
        int minBairro = Math.min(15, bairro.length());
        bairro = bairro.substring(0, minBairro).toUpperCase();

        String cidade = contrato.getCliente().getEnderenco().getCidade().toUpperCase();
        int minCidade = Math.min(30, cidade.length());
        cidade = cidade.substring(0, minCidade);

        String uf = contrato.getCliente().getEnderenco().getUf().toUpperCase();
        int minUf = Math.min(2, uf.length());
        uf = uf.substring(0, minUf);

        String cep = contrato.getCliente().getEnderenco().getCep().replaceAll("\\.", "");
        int minCep = Math.min(8, cep.length());
        cep = cep.substring(0, minCep);

        String siglaPais = contrato.getCliente().getEnderenco().getPais().getSigla();

        Long longProtocolo = Long.parseLong(contrato.getProtocolo());
        String protocolo = String.format("%010d", longProtocolo);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        String dataFormatada = contrato.getAgendamento().toLocalDate().format(df);
        dataFormatada = dataFormatada.replaceAll("/", "");

        String horaFormatada = contrato.getAgendamento().toLocalTime().toString();
        int minHora = Math.min(5, horaFormatada.length());
        horaFormatada = horaFormatada.substring(0, minHora).replaceAll(":", "");

        String siglaTipoServico = contrato.getTipoServico().getSigla();

        String valorTipoServico = contrato.getTipoServico().getValor().toString();
        valorTipoServico = valorTipoServico.replaceAll("\\.", "");
        valorTipoServico = "000".concat(valorTipoServico);

        String siglaNotificacao = contrato.getNotificacao().getSigla();

        sb.append(cpf).append(";").append(nome).append(";").append(logradouro).append(";")
                .append(complemento).append(";").append(bairro).append(";")
                .append(cidade).append(";").append(uf).append(";").append(cep).append(";")
                .append(siglaPais).append(";").append(protocolo).append(";")
                .append(dataFormatada).append(";").append(horaFormatada).append(";")
                .append(siglaTipoServico).append(";").append(valorTipoServico).append(";")
                .append(siglaNotificacao).append(";").append("\n");

        System.out.println(sb);

        criarArquivo(sb, "csv");
    }

    private static void criarArquivo(StringBuilder sb, String sufixo) throws IOException {
        String nomeArquivo = "agua-luz-contratos."+ sufixo;
        File diretorio = new File("C:\\Users\\User\\MJV\\agua-luz-output");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        File arquivo = new File(diretorio, nomeArquivo);
        arquivo.createNewFile();

        try {
            Writer path = new BufferedWriter(new FileWriter(arquivo, true));
            path.append(sb);
            path.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}