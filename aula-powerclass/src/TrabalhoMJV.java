package powerclasses.src;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TrabalhoMJV {

    public static void main(String[] args) throws IOException {
        File caminho = new File("C:/Users/User/MJV/arquivos/arquivo.txt");

        boolean novoArquivo = caminho.createNewFile();
        System.out.println(novoArquivo ? "Criado com sucesso." : "Erro ao criar");

        String nome = caminho.getName();
        System.out.println("O arquivo foi nomeado como " + nome);

        Path arquivo = Paths.get(caminho.toString());

        /* Outra alternativa:
        Path arquivo = caminho.toPath();*/

        // Escrevendo um conteúdo para ser digitaodo no arquivo
        String conteudo = "MJV School Java - Power Classes";

        /* Escrevendo o conteúdo no arquivo que foi criado e posteriormente selecionado,
            selecionando a codificação UTF_8 para não haver imcompatibilidade de caracteres */
        Files.writeString(arquivo, conteudo, UTF_8);

        // Lendo os dados do arquivo utilizando o readString e os exibindo no console
        System.out.println("O arquivo " + nome + " possui o seguinte o conteúdo " + Files.readString(arquivo, UTF_8));

        existeTamanho(arquivo);

        int numeroArquivos = arquivo.getNameCount();
        System.out.println("Existem " + numeroArquivos +  " nomes no caminho do Path ");

        URI uriVal = arquivo.toUri();
        System.out.println("O URI é  " + uriVal );

        boolean apenasLeitura = caminho.setReadOnly();
        System.out.println(apenasLeitura ? "Alterado com sucesso." : "Erro ao alterar");

        boolean deletar = caminho.delete();
        System.out.println(deletar ? "Deletado com sucesso." : "Erro ao deletar");
    }
    public static void existeTamanho(Path arquivo) {

        // retorna true se o diret�rio ou arquivo do objeto File existe, falso o contr�rio

        if (arquivo.toFile().exists()) {
            System.out.println("O caminho especificado existe !");

            // Mostra o tamanho do arquivo em bytes;
            int size = arquivo.toString().length();
            System.out.println("O tamanho do arquivo em bytes e: " + size + " bytes");

        } else
            System.out.println("Endereco errado");
    }
}
