package powerclasses.src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TrabalhoMJV {

    public static void main(String[] args) throws IOException {
        File caminho = new File("C:/Users/User/MJV/arquivos/arquivo.txt");

        boolean novoArquivo = caminho.createNewFile();
        System.out.println(novoArquivo ? "Criado com sucesso." : "Erro ao criar");

        String nome = caminho.getName();
        System.out.println(nome);

        existeTamanho(caminho);

        boolean apenasLeitura = caminho.setReadOnly();
        System.out.println(apenasLeitura ? "Alterado com sucesso." : "Erro ao alterar");

        boolean deletar = caminho.delete();
        System.out.println(deletar ? "Deletado com sucesso." : "Erro ao deletar");
    }
    public static void existeTamanho(File caminho) {
        Path arquivo = Paths.get(caminho.toString());

        // retorna true se o diret�rio ou arquivo do objeto File existe, falso o contr�rio

        if (arquivo.toFile().exists()) {
            System.out.println("O caminho especificado existe !");

            // Mostra o tamanho do arquivo em bytes;
            int size = caminho.toString().length();
            System.out.println("O tamanho do arquivo em bytes e: " + size + " bytes");

        } else
            System.out.println("Endereco errado");
    }
}
