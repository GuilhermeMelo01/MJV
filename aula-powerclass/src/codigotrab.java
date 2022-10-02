package teste; 

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class codigotrab {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);			
	
		System.out.print("Entre com um endere�o v�lido de um arquivo: ");
		// solicita que o usu�rio escreva o caminho do arquivo
		//exemplo: C:\teste\arquivos\teste.txt
		String caminho = sc.nextLine();
		
		existeTamanho(caminho);
	}

	public static void existeTamanho(String caminho) {
		Path arquivo = Paths.get(caminho);
		
		// retorna true se o diret�rio ou arquivo do objeto File existe, falso o contr�rio
		
		if (arquivo.toFile().exists()) {
			System.out.println("O caminho especificado existe !");
			
			// Mostra o tamanho do arquivo em bytes;
			int size = caminho.length();
			System.out.println("O tamanho do arquivo em bytes �: " + size + " bytes");

		} else
			System.out.println("Endere�o errado");
	}
}
