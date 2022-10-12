package service;

import model.Extrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		this.extrato = new ArrayList<>();
	}

	public void gravar(Extrato ext){
		//criado arquivo extrato para salvar os dados das transacoes da conta
		File arquivo = new File("extrato.dat");
		ArrayList<Extrato> extratoArrayList = new ArrayList<>();

		extratoArrayList = recuperaArquivo(extratoArrayList);
		extratoArrayList.add(ext);
		try{
			FileOutputStream fout = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			//dados são gravados na classe ObjectOutputStream
			oos.writeObject(extratoArrayList);

			//classe salva os dados gravados nela no arquivo
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

	public ArrayList<Extrato> recuperaArquivo(ArrayList<Extrato> extratoArrayList ){
		File arquivo = new File("extrato.dat");

		try{
			FileInputStream fin = new FileInputStream(arquivo);
			ObjectInputStream oin = new ObjectInputStream(fin);

			extratoArrayList = (ArrayList<Extrato>) oin.readObject();

			oin.close();
			fin.close();
		}catch(Exception ex){
			System.err.println("Erro: " + ex.toString());
		}

		return extratoArrayList;
	}

	public void montaExtrato(LocalDate data1, LocalDate data2){
		//imprme todos os dados do extrato
		String cabeçalho = "=============\nExtrato Bancário\n";
			DateTimeFormatter dataE = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(Extrato e : this.extrato){
			if((!e.data.isBefore(data1) || e.data.isEqual(data1)) && (!e.data.isAfter(data2) || e.data.isEqual(data2))) {
				String corpo = "Data: " + e.data.format(dataE) + "\nOperacao: " + e.operacao + "\n"
						+ (e.operacao.equals("TRANSFERÊNCIA") ? "Conta Transferência: "
						+ e.contaDestino + "\nValor: " + e.saldoDaConta + "\n" : "Valor: "
						+ e.saldoDaConta + "\n") + "Status da Conta: "
						+ (e.statusDaConta ? "ABERTA" : "ENCERRADA") + "\n=================\n";
				cabeçalho = cabeçalho.concat(corpo);
			}
		}
		System.out.println(cabeçalho);
	}
}