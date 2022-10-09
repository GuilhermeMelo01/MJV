package model;

import exception.SaldoInsuficienteException;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ContaBancaria {
    private String numeroConta;
    private String numeroAgencia;
    private String nomeCliente;
    private LocalDate dataDeNascimento;
    private BigDecimal saldoDaConta;
    private Boolean statusDaConta;

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
    	}
    	catch(SaldoInsuficienteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void transferir(BigDecimal valor, ContaBancaria conta) {
        try{
            verificarSaldo(valor, conta);
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
    	if (valor.compareTo(saldoDaConta) <= 0) {
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
}
