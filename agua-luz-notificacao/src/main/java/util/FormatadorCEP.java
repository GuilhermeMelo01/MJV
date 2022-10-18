package util;

public class FormatadorCEP {

    public static String formatadorCEP(String cep) {
        String bloco1 = cep.substring(0,2);
        String bloco2 = cep.substring(2,5);
        String bloco3 = cep.substring(5,8);

        return String.format("%s.%s-%s", bloco1, bloco2, bloco3);
    }
}
