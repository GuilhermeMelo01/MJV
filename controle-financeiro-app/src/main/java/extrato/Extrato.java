package extrato;
import extrato.ExtratoService;
import model.ContaBancaria;
import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
public class Extrato implements Serializable{
	private LocalDate data;
	private String operacao;

	private String contaOrigen;
	private String contaDestino;
	private BigDecimal saldoDaConta;
	private Boolean statusDaConta;

	public Extrato(ContaBancaria contaDestino, BigDecimal valor, Boolean status){
		//seta a data da operação.
		this.data = LocalDate.now();
		this.operacao = "TRANSFERÊNCIA";
		this.contaDestino = contaDestino.getNumeroConta() + " - " + contaDestino.getNumeroAgencia();
		this.saldoDaConta = valor;
		this.statusDaConta = status;
	}

	public Extrato(String operacao, BigDecimal valor){
		//seta a data da operação.
		this.data = LocalDate.now();
		this.operacao = operacao;
		this.contaDestino = "";
		this.saldoDaConta = valor;
		this.statusDaConta = false;
	}

	public void gravarDados(Extrato ext){
		ExtratoService extS = new ExtratoService();
		extS.gravar(ext);
	}
}