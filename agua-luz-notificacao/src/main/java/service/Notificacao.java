package service;

import util.FormatadorCEP;
import util.FormatadorCPF;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Notificacao {

    public void notificar(ArrayList<String> contrato) {

        for (int i = 0; i < contrato.toArray().length; i++) {

            StringBuilder stringBuilder = new StringBuilder();

            String cpf = contrato.get(i).substring(0, 11); //1
            String nome = contrato.get(i).substring(11, 42); //2
            String logradouro = contrato.get(i).substring(42, 62); //3
            String complemento = contrato.get(i).substring(62, 72); //4
            String bairro = contrato.get(i).substring(72, 87); //5
            String cidade = contrato.get(i).substring(87, 117); //6
            String uf = contrato.get(i).substring(117, 119);
            String cep = contrato.get(i).substring(119, 127);
            //sigla - 2
            String protocolo = contrato.get(i).substring(129, 139);
            String data = contrato.get(i).substring(139, 147);
            String hora = contrato.get(i).substring(147, 151);

            String servico = contrato.get(i).substring(151, 152);
            if (servico.equals("A")){
                servico = "Água";
            }else{
                servico = "Luz";
            }

            String valor = contrato.get(i).substring(152, 160).replaceAll("0", "");
            String valorPosVirgula = valor.substring(3, 5);
            String valorPreVirgula = valor.substring(0, 3);
            valor = valorPreVirgula.concat(",").concat(valorPosVirgula);

            cpf = FormatadorCPF.formatadorCPF(cpf);

            String ano = data.substring(0, 4);
            String mes = data.substring(4, 6);
            String dia = data.substring(6, 8);
            data = ano.concat("/").concat(mes).concat("/").concat(dia);

            String horas = hora.substring(0, 2);
            String minuto = hora.substring(2, 4);

            hora = horas.concat(":").concat(minuto);

            cep = FormatadorCEP.formatadorCEP(cep);


            stringBuilder.append("Senhor(a) ").append(nome).append(" cpf de número ").append(cpf).append(",")
                    .append(" informamos que conforme contrato com protocolo de número ").append(protocolo)
                    .append("\nestá ").append("agendado para a data/hora ").append(data).append(" às ")
                    .append(hora).append("h a instalação do serviço de ").append(servico).append(" com taxa de valor R$ ")
                    .append(valor).append(" em sua residência localizada no endereço abaixo:\n\n")
                    .append("Logradouro: ")
                    .append(logradouro)
                    .append("\nComplemento: ")
                    .append(complemento).append("\nBairro: ")
                    .append(bairro).append("\nCidade: ")
                    .append(cidade).append("/")
                    .append(uf).append("\nCep: ").append(cep).append("\n");

            String stringTest = stringBuilder.toString().replaceAll("#", "");
            System.out.println(stringTest);
        }
    }

    public ArrayList<String> ler() {
        Path arquivo = Paths.get("C:\\Users\\User\\MJV\\agua-luz-output\\agua-luz-contratos.txt");

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
