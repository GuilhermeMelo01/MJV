import exception.SaldoInsuficienteException;
import exception.ValidacaoDataException;
import model.ContaCorrente;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws ValidacaoDataException, SaldoInsuficienteException {
        ContaCorrente conta01 = new ContaCorrente("3289", "2000", "Guilherme",
                LocalDate.of(2001, 11, 9), BigDecimal.valueOf(500), true);

        ContaCorrente conta02 = new ContaCorrente("0010", "4324", "Maria",
                LocalDate.of(2003, 8, 12), BigDecimal.valueOf(500), true);


        System.out.println("Saldo da conta01 inicial: "+ conta01.getSaldoDaConta());
        System.out.println("Saldo da conta02 inicial: "+ conta02.getSaldoDaConta());
        System.out.println("======================================================");

        conta01.sacar(BigDecimal.valueOf(200));
        System.out.println("Valor do saque: 200");
        System.out.println("Saldo da conta01 após o saque: "+ conta01.getSaldoDaConta());
        System.out.println("======================================================");

        conta01.depositar(BigDecimal.valueOf(300));
        System.out.println("Valor do deposito: 300");
        System.out.println("Saldo da conta01 após o deposito: "+ conta01.getSaldoDaConta());
        System.out.println("======================================================");

        conta01.transferir(BigDecimal.valueOf(250), conta02);
        System.out.println("Valor da transferencia da conta01 para a conta02: 250");
        System.out.println("Saldo da conta01: "+ conta01.getSaldoDaConta());
        System.out.println("Saldo da conta02: "+ conta02.getSaldoDaConta());
        System.out.println("======================================================");

        conta01.cancelarConta(true, "Não quero ter mais uma conta!");
        System.out.println("Status da conta após ser cancelada: "+ conta01.getStatusDaConta());
        System.out.println("======================================================");

    }
}
