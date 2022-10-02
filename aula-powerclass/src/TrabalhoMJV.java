package powerclasses.src;

import java.io.File;
import java.io.IOException;

public class TrabalhoMJV {

    public static void main(String[] args) throws IOException {

        File caminho = new File("C:/Users/User/MJV/arquivos/arquivo.txt");

        boolean novoArquivo = caminho.createNewFile();
        System.out.println(novoArquivo);

        String nome = caminho.getName();
        System.out.println(nome);

        boolean apenasLeitura = caminho.setReadOnly();
        System.out.println(apenasLeitura);

        boolean deletar = caminho.delete();
        System.out.println(deletar);
    }
}
