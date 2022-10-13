package model;

import exception.SaldoInsuficienteException;
import exception.ValidacaoDataException;
import service.ExtratoService;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {

    protected final String numeroConta;
    protected final String numeroAgencia;
    protected BigDecimal saldoDaConta;
    protected Boolean statusDaConta;
    protected Cliente cliente;
    protected LocalDate dataAbertura;
    protected LocalDate dataCancelamento;

    public Conta(String numeroConta, String numeroAgencia, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.cliente = cliente;
        this.saldoDaConta = BigDecimal.valueOf(0.0);
        this.statusDaConta = true;
        this.dataAbertura = LocalDate.now();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getSaldoDaConta() {
        return saldoDaConta;
    }

    public Boolean getStatusDaConta() {
        return statusDaConta;
    }

    public void setStatusDaConta(Boolean statusDaConta) {
        this.statusDaConta = statusDaConta;
    }

    public void depositar(BigDecimal deposito) throws SaldoInsuficienteException {
        if (deposito.compareTo(BigDecimal.ZERO) < 0) {
            throw new SaldoInsuficienteException("Saldo ou Depósito não pode ser menor que 0");
        } else {
            this.saldoDaConta = saldoDaConta.add(deposito);
            Extrato ext = new Extrato("DEPOSITO", deposito, getStatusDaConta());
            ext.gravarDados(ext);
        }
    }

    public void sacar(BigDecimal valor) {
        try {
            verificarSaldo(valor);
            Extrato ext = new Extrato("SAQUE", valor, getStatusDaConta());
            ext.gravarDados(ext);
        } catch (SaldoInsuficienteException e) {
            e.printStackTrace();
        }
    }

    public void transferir(BigDecimal valor, Conta conta) {
        try {
            verificarSaldo(valor, conta);
            Extrato ext = new Extrato(conta, valor, getStatusDaConta());
            ext.gravarDados(ext);
        } catch (SaldoInsuficienteException e) {
            e.printStackTrace();
        }
    }

    public void cancelarConta(String justificativa) {
        if (!justificativa.isBlank() && this.statusDaConta) {
            this.statusDaConta = false;
            this.dataCancelamento = LocalDate.now();
            Extrato ext = new Extrato("CANCELAMENTO", BigDecimal.valueOf(0), getStatusDaConta());
            ext.gravarDados(ext);
        } else if (justificativa.isBlank()) {
            System.out.println("Justificativa não preenchida");
        } else {
            System.out.println("Sua conta já encontra-se cancelada");
        }
    }

    public void imprimirExtrato(LocalDate data1, LocalDate data2) throws ValidacaoDataException {
        if (data1.toString().isBlank() || data2.toString().isBlank()) {
            throw new ValidacaoDataException("Data não informada.");
        } else if (data2.isAfter(data1) || data2.equals(data1)) {
            ExtratoService extS = new ExtratoService();
            extS.ler();
            extS.montaExtrato(data1, data2);
        } else {
            throw new ValidacaoDataException("Segunda Data Menor que a Primeira.");
        }
    }

    public void verificarSaldo(BigDecimal valor) throws SaldoInsuficienteException {
        if (valor.compareTo(this.saldoDaConta) <= 0) {
            saldoDaConta = saldoDaConta.subtract(valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para essa transaçao.");
        }
    }

    public void verificarSaldo(BigDecimal valor, Conta conta) throws SaldoInsuficienteException {
        if (valor.compareTo(this.saldoDaConta) <= 0) {
            this.saldoDaConta = this.saldoDaConta.subtract(valor);
            conta.saldoDaConta = conta.saldoDaConta.add(valor);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para essa transaçao.");
        }
    }
}

