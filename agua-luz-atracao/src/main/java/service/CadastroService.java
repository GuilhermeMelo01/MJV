package service;

import model.Cliente;
import model.Contrato;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CadastroService {

    public static void geradorArquivoPosicional(Cliente cliente, Contrato contrato) {
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

        String cidade = cliente.getEnderenco().getCidade().toUpperCase();
        int minCidade = Math.min(30, cidade.length());
        cidade = cidade.substring(0, minCidade);

        String uf = cliente.getEnderenco().getUf().toUpperCase();
        int minUf = Math.min(2, uf.length());
        uf = uf.substring(0, minUf);

        String cep = cliente.getEnderenco().getCep().replaceAll("\\.", "");
        int minCep = Math.min(8, cep.length());
        cep = cep.substring(0, minCep);

        String siglaPais = cliente.getEnderenco().getPais().getSigla();

        int longProtocolo = Integer.parseInt(contrato.getProtocolo());
        String protocolo = String.format("%010d", longProtocolo);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.ENGLISH);
        String dataFormatada = contrato.getAgendamento().toLocalDate().format(df);
        int minData = Math.min(8, dataFormatada.length());
        dataFormatada = dataFormatada.substring(0, minData).replaceAll("/", "");

        String horaFormatada = contrato.getAgendamento().toLocalTime().toString();
        int minHora = Math.min(4, horaFormatada.length());
        horaFormatada = horaFormatada.substring(0, minHora).replaceAll(":", "");

        String siglaTipoServico = contrato.getTipoServico().getSigla();

        String valorTipoServico = contrato.getTipoServico().getValor().toString();
        valorTipoServico = valorTipoServico.replaceAll("\\.", "");
        valorTipoServico = "000".concat(valorTipoServico);

        String siglaNotificacao = contrato.getNotificacao().getSigla();

        sb.append(cpf).append(nome).append(logradouro).append(complemento).append(bairro)
                .append(cidade).append(uf).append(cep).append(siglaPais).append(protocolo)
                .append(dataFormatada).append(horaFormatada).append(siglaTipoServico)
                .append(valorTipoServico).append(siglaNotificacao).append("\n");

        System.out.println(sb.toString());

        String nomeArquivo = "agua-luz-contratos.txt";
        File diretorio = new File("C:\\Users\\User\\MJV\\agua-luz-atracao");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        File arquivo = new File(diretorio, nomeArquivo);
        Path path = arquivo.toPath();
        try {
            Files.writeString(path, sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}