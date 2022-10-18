package util;

public class FormatadorCPF {

    public static String formatadorCPF(String cpf) {
        String bloco1 = cpf.substring(0, 3);
        String bloco2 = cpf.substring(3, 6);
        String bloco3 = cpf.substring(6, 9);
        String bloco4 = cpf.substring(9, 11);

        return String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4);
    }
}
