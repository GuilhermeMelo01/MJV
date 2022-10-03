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

		// Cria um arquivo no diretório especificado
		File arquivo = new File("C:/Users/User/MJV/arquivos/arquivo.txt");

		// Retorna true ou false caso o arquivo seja criado ou não
		boolean novoArquivo = arquivo.createNewFile();
		System.out.println(novoArquivo ? "Criado com sucesso." : "Erro ao criar");

		// Retorna o nome do arquivo criado
		String nome = arquivo.getName();
		System.out.println("O arquivo foi nomeado como " + nome);

		// Determina o objeto caminho e converte a String de caminho em Path
		Path caminho = Paths.get(arquivo.toString());

		/*
		 * Outra alternativa: Path arquivo = caminho.toPath();
		 */

		// Escrevendo um conteúdo para ser digitado no arquivo
		String conteudo = "MJV School Java - Power Classes";

		/*
		 * Escrevendo o conteúdo no arquivo que foi criado e posteriormente selecionado,
		 * selecionando a codificação UTF_8 para não haver imcompatibilidade de
		 * caracteres
		 */
		Files.writeString(caminho, conteudo, UTF_8);

		// Lendo os dados do arquivo utilizando o readString e os exibindo no console
		System.out.println("O arquivo " + nome + " possui o seguinte o conteúdo " + Files.readString(caminho, UTF_8));

		//Passando o arquivo de File para Path
		Path path = arquivo.toPath();

		// Comparando 2 arquivos para saberem se são copias exatas
		long mismatchFiles = Files.mismatch(path, caminho);
		if (mismatchFiles == -1) {
			System.out.println("Arquivos são copias exatas");
		} else {
			System.out.println("Arquivos não iguais!");
		}
		
		// ler todos os bytes de um arquivo
		byte[] totalBytes = Files.readAllBytes(caminho);
		System.out.println("Bytes do arquivo: " + totalBytes.length);

		// Valida se o caminho existe
		existeTamanho(caminho);

		// Retorna o número de elementos no caminho do diretório
		int numeroArquivos = caminho.getNameCount();
		System.out.println("Existem " + numeroArquivos + " elementos no caminho do Path ");

		// Retorna a URI do arquivo
		URI uriVal = caminho.toUri();
		System.out.println("O URI é  " + uriVal);

		// Altera o estado do arquivo para "somente leitura"
		boolean apenasLeitura = arquivo.setReadOnly();
		System.out.println(apenasLeitura ? "Alterado com sucesso." : "Erro ao alterar");

		// Deleta o arquivo
		boolean deletar = arquivo.delete();
		System.out.println(deletar ? "Deletado com sucesso." : "Erro ao deletar");
	}

	public static void existeTamanho(Path arquivo) {

		// retorna true se o diretorio ou arquivo do objeto File existe, falso o
		// contrario

		if (arquivo.toFile().exists()) {
			System.out.println("O caminho especificado existe !");

			// Mostra o tamanho do arquivo em bytes;
			int size = arquivo.toString().length();
			System.out.println("O tamanho do arquivo em bytes e: " + size + " bytes");

		} else
			System.out.println("Endereco errado");
	}
}
