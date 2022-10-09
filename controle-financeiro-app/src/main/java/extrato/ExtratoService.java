package extrato;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ExtratoService {
	private ArrayList<Extrato> extrato;
	
	public ExtratoService(){
		//construtor da classe extrato cria arraylist de dados
		this.extrato = new ArrayList<Extrato>();
	}
	public void gravar(Extrato ext){
		//criado arquivo extrato para salvar os dados das transacoes da conta
		File arquivo = new File("extrato.dat");
		
		try{
			FileOutputStream fout = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			//dados são gravados na classe ObjectOutputStream
			oos.writeObject(ext);
			
			//classe salva os dados gravados nela no arquivo 
			oos.flush();
			oos.close();
			fout.close();
		}catch(Exception ex){
			//caso ocorra algum erro mensagem é apresentada
			System.err.println("Erro: " + ex.toString());
		}
	}
	
	public void ler(){
		File arquivo = new File("extrato.dat");

		try{
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			this.extrato = (ArrayList<Extrato>) oin.readObject();
			
			oin.close();
			fin.close();
			
			for(Extrato e : this.extrato){
				e.toString();
			}
		}catch(Exception ex){
			System.err.println("Erro: " + ex.toString());
		}
	}
}