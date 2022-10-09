package model;

import exception.SaldoInsuficienteException;
import exception.ValidacaoDataException;
import extrato.Extrato;
import extrato.ExtratoService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


public class ContaBancaria {
    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private LocalDate dataDeNascimento;
    private BigDecimal saldoDaConta;
    private Boolean statusDaConta;

    private ArrayList<Extrato> montarExtrato;

    public ContaBancaria() {
    }

    public ContaBancaria(String numeroConta, String numeroAgencia, String nomeCliente,
                         LocalDate dataDeNascimento, BigDecimal saldoDaConta, Boolean statusDaConta) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.nomeCliente = nomeCliente;
        this.dataDeNascimento = dataDeNascimento;
        this.saldoDaConta = saldoDaConta;
        this.statusDaConta = statusDaConta;
    }

    public void sacar(BigDecimal valor){
    	try {
    		verificarSaldo(valor);
            Extrato ext = new Extrato("SAQUE", valor, getStatusDaConta());
            ext.gravarDados(ext);
        }
    	catch(SaldoInsuficienteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void transferir(BigDecimal valor, ContaBancaria conta) {
        try{
            verificarSaldo(valor, conta);
            Extrato ext = new Extrato(conta,valor, getStatusDaConta());
            ext.gravarDados(ext);
        }catch (SaldoInsuficienteException e){
            e.printStackTrace();
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public BigDecimal getSaldoDaConta() {
        return saldoDaConta;
    }

    public Boolean getStatusDaConta() {
        return statusDaConta;
    }
    
    private void verificarSaldo(BigDecimal valor) throws SaldoInsuficienteException {
    	if (valor.compareTo(this.saldoDaConta) <= 0) {
    		saldoDaConta = saldoDaConta.subtract(valor);
    		}
    	else {
    		throw new SaldoInsuficienteException("Saldo insuficiente para essa transação.");
    	}
    }

    private void verificarSaldo(BigDecimal valor, ContaBancaria conta) throws SaldoInsuficienteException {
        if (valor.compareTo(this.saldoDaConta) <= 0) {
            this.saldoDaConta = this.saldoDaConta.subtract(valor);
            conta.saldoDaConta = conta.saldoDaConta.add(valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para essa transação.");
        }
    }

    private void imprimirExtrato(LocalDate data1, LocalDate data2) throws ValidacaoDataException {
        if (data1.toString().isBlank() || data2.toString().isBlank()) {
            throw new ValidacaoDataException("Data não informada.");
        } else if(data2.isAfter(data1)) {
            ExtratoService extS = new ExtratoService();
            extS.ler();
            extS.montaExtrato(data1, data2);
        } else{
            throw new ValidacaoDataException("Segunda Data Menor que a Primeira.");
        }
    }
    
    public void depositar(BigDecimal deposito) throws SaldoInsuficienteException {
    	if (deposito.compareTo(BigDecimal.ZERO) < 0) {
			throw new SaldoInsuficienteException("Saldo ou Depósito não pode ser menor que 0");
		} else {
			saldoDaConta = saldoDaConta.add(deposito);
		}
	}
}

