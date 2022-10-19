package service;

import model.Contrato;
import util.FormatadorCEP;
import util.FormatadorCPF;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notificacao {

    public void notificar(ArrayList<String> contrato) {

        for (int i = 0; i < contrato.toArray().length; i++) {

            StringBuilder stringBuilder = new StringBuilder();

            String nome = contrato.get(i).substring(30, 61);
            String cpf = contrato.get(i).substring(0, 11);
            String protocolo = contrato.get(i).substring(148, 158);
            String data = contrato.get(i).substring(158, 166);
            String hora = contrato.get(i).substring(166, 170);
            String servico = contrato.get(i).substring(171, 171);
            String valor = contrato.get(i).substring(172, 176);
            String cep = contrato.get(i).substring(138, 146);
            String logradouro = contrato.get(i).substring(138, 146);
            String numero = contrato.get(i).substring(138, 146);
            String complemento = contrato.get(i).substring(138, 146);
            String bairro = contrato.get(i).substring(138, 146);
            String cidade = contrato.get(i).substring(138, 146);
            String uf = contrato.get(i).substring(138, 146);

            cpf = FormatadorCPF.formatadorCPF(cpf);

            String ano = data.substring(0,4);
            String mes = data.substring(4,6);
            String dia = data.substring(6,8);
            data = ano.concat("/").concat(mes).concat("/").concat(dia);

            String horas = hora.substring(0,2);
            String minuto = hora.substring(2,4);

            hora = horas.concat(":").concat(minuto);

            cep =  FormatadorCEP.formatadorCEP(cep);


            stringBuilder.append("Senhor(a) ").append(nome).append(" cpf de número ").append(cpf).append(",")
                    .append(" informamos que conforme contrato com protocolo de número ").append(protocolo)
                    .append("\nestá ").append("agendado para a data/hora ").append(data).append(" às ")
                    .append(hora).append("h a instalação do serviço de ").append(servico).append(" com taxa de valor R$ ")
                    .append(valor).append(" em sua residência localizada no endereço abaixo:\n\n")
                    .append("Logradouro: ")
                    .append(logradouro).append(", ")
                    .append(numero).append("\n").append("Complemento: ")
                    .append(complemento).append("\n").append("Bairro: ")
                    .append(bairro).append("\n").append("Cidade: ")
                    .append(cidade).append("/")
                    .append(uf).append("\n").append("Cep: ").append(cep);

            String stringTest = stringBuilder.toString().replaceAll("#","");
            System.out.println(stringTest);
        }
    }

    public ArrayList<String> ler() {
        Path arquivo = Paths.get("C:\\Users\\warlo\\Java\\Projects\\mjv_school_java\\aula_git\\agua-luz-atracao\\agua-luz-output.txt");

        ArrayList<String> contratoList = null;
        try {

            String contrato = new String(Files.readAllBytes(arquivo));
            contratoList = new ArrayList<String>();

            String[] contratoSeparado = contrato.split("\\n");

            for (int i = 0; i < contratoSeparado.length; i++) {
                contratoList.add(contratoSeparado[i]);
            }

        } catch (Exception ex) {
            System.err.println("Erro: " + ex.toString());
        }
        return contratoList;
    }
}
