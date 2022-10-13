import exception.SaldoInsuficienteException;
import exception.ValidacaoDataException;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException, ValidacaoDataException {
        Cliente cl1 = new Cliente();
        cl1.setNome("Guilherme");
        cl1.setCpf("0123456789");
        cl1.setDataDeNascimento(LocalDate.of(2001, 11, 9));

        Conta conta01 = new ContaCorrente("3289", "2000", cl1);

        Conta conta02 = new ContaCorrente("0010", "4324", cl1);

        conta01.depositar(BigDecimal.valueOf(500));
        conta02.depositar(BigDecimal.valueOf(500));
        System.out.println("Depositando");

        conta01.sacar(BigDecimal.valueOf(200));
        conta01.depositar(BigDecimal.valueOf(300));
        conta01.transferir(BigDecimal.valueOf(250), conta02);
        conta01.cancelarConta("Não quero ter mais uma conta!");

//        conta01.imprimirExtrato(LocalDate.of(2022, 10, 9),
//                LocalDate.of(2022, 10, 12));
        
//        observação para teste
    }
}
