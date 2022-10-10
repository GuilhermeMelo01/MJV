package extrato;

import model.ContaBancaria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Extrato implements Serializable{

	public LocalDate data;
	public String operacao;
	public String contaDestino;
	public BigDecimal saldoDaConta;
	public Boolean statusDaConta;

	public Extrato(ContaBancaria contaDestino, BigDecimal valor, Boolean status){
		//seta a data da operação.
		this.data = LocalDate.now();
		this.operacao = "TRANSFERÊNCIA";
		this.contaDestino = contaDestino.getNumeroConta() + " - " + contaDestino.getNumeroAgencia();
		this.saldoDaConta = valor;
		this.statusDaConta = status;
	}

	public Extrato(String operacao, BigDecimal valor, Boolean status){
		//seta a data da operação.
		this.data = LocalDate.now();
		this.operacao = operacao;
		this.contaDestino = "";
		this.saldoDaConta = valor;
		this.statusDaConta = status;
	}

	public void gravarDados(Extrato ext){
		ExtratoService extS = new ExtratoService();
		extS.gravar(ext);
	}
}