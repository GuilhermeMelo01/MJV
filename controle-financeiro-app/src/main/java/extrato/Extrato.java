package extrato;
import extrato.ExtratoService;
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

	public Extrato(String contaDestino, BigDecimal valor){
		//seta a data da operação.
		this.data = LocalDate.now();
		this.operacao = "TRANSFERÊNCIA";
		this.contaDestino = contaDestino;
		this.saldoDaConta = BigDecimal.valueOf(0);
		this.statusDaConta = false;
	}

	public Extrato(String operacao){
		//seta a data da operação.
		this.data = LocalDate.now();
		this.operacao = operacao;
		this.contaDestino = "";
		this.saldoDaConta = BigDecimal.valueOf(0);
		this.statusDaConta = false;
	}

	public void gravarDados(Extrato ext){
		ExtratoService extS = new ExtratoService();
		extS.gravar(ext);
	}
}