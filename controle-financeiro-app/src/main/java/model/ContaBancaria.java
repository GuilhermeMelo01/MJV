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
            Extrato ext = new Extrato("SAQUE", valor);
            ext.gravarDados(ext);
        }
    	catch(SaldoInsuficienteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void transferir(BigDecimal valor, ContaBancaria conta) {
        try {
            verificarSaldo(valor, conta);
            Extrato ext = new Extrato(conta,valor, getStatusDaConta());
            ext.gravarDados(ext);
        } catch (SaldoInsuficienteException e){
            e.printStackTrace();
        }
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

    private void imprimirExtrato(LocalDate data1, LocalDate data2) throws ValidacaoDataException {
        if (data1.toString().isBlank() || data1.toString().isBlank()) {
            throw new ValidacaoDataException("Saldo insuficiente para essa transação.");
        } else if(data2.isBefore(data1)) {
            ExtratoService extS = new ExtratoService();
            extS.ler();
            extS.montaExtrato();
        }
    }

    public void cancelarConta(Boolean statusConta, String justificativa) {
        if (!justificativa.isBlank() && statusConta == true) {
            this.statusDaConta = false;
        } else if (justificativa.isBlank()) {
            System.out.println("Justificativa não preenchida");
        } else {
            System.out.println("Sua conta já encontra-se cancelada");
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public BigDecimal getSaldoDaConta() {
        return saldoDaConta;
    }

    public Boolean getStatusDaConta() {
        return statusDaConta;
    }
}
