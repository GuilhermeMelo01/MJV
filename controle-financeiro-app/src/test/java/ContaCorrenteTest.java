import exception.SaldoInsuficienteException;
import exception.ValidacaoDataException;
import model.ContaCorrente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaCorrenteTest {

    ContaCorrente conta01 = new ContaCorrente("3289", "2000", "Guilherme",
            LocalDate.of(2001, 11, 9), BigDecimal.valueOf(500), true);

    ContaCorrente conta02 = new ContaCorrente("0010", "4324", "Maria",
            LocalDate.of(2003, 8, 12), BigDecimal.valueOf(500), true);


    @DisplayName("Teste para verificar se o deposito foi realizado com sucesso")
    @Test
    void verificaSeDepositoFoiRealizado() throws SaldoInsuficienteException {
        conta01.depositar(BigDecimal.valueOf(300));
        BigDecimal expectativa = new BigDecimal(800);
        BigDecimal resultado = conta01.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se o usuário realizou o saque com sucesso")
    @Test
    void verificaSeOSaqueFoiRealizado() {
        conta01.sacar(BigDecimal.valueOf(100));
        BigDecimal expectativa = new BigDecimal(400);
        BigDecimal resultado = conta01.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se a exception de saldo insuficiente para saque foi lançada")
    @Test
    void verificaExceptionSaldoInsuficienteSaque() {
        String expectativa = "Saldo insuficiente para essa transaçao.";
        SaldoInsuficienteException resultado = Assertions.assertThrows(SaldoInsuficienteException.class,
                () -> conta01.verificarSaldo(BigDecimal.valueOf(52815)));

        Assertions.assertEquals(expectativa, resultado.getMessage());
    }

    @DisplayName("Teste para verificar se o valor esta sendo descontado no saldo da conta origem")
    @Test
    void verificaSeOValorFoiRetiradoDaConta(){

        conta01.transferir(BigDecimal.valueOf(200), conta02);
        BigDecimal expectativa = new BigDecimal(300);
        BigDecimal resultado = conta01.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se o valor esta sendo depositado no saldo da conta destino")
    @Test
    void verificaSeOValorFoiDepositadoNaConta(){

        conta01.transferir(BigDecimal.valueOf(200), conta02);
        BigDecimal expectativa = new BigDecimal(700);
        BigDecimal resultado = conta02.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se a exception de saldo insuficiente para transferencia foi lançada")
    @Test
    void verificaExceptionSaldoInsuficienteTransferencia() {
        String expectativa = "Saldo insuficiente para essa transaçao.";
        SaldoInsuficienteException resultado = Assertions.assertThrows(SaldoInsuficienteException.class,
                () -> conta01.verificarSaldo(BigDecimal.valueOf(500870), conta01));

        Assertions.assertEquals(expectativa, resultado.getMessage());
    }

    @DisplayName("Teste para verificar se conta foi cancelada com sucesso")
    @Test
    void verificaSeAContaFoiCancelada() {
        conta01.cancelarConta(true, "justificativa teste");
        Boolean expectativa = false;
        Boolean resultado = conta01.getStatusDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se a exception de data foi lançada")
    @Test
    void verificaDataException() {
        String expectativa = "Segunda Data Menor que a Primeira.";
        ValidacaoDataException resultado = Assertions.assertThrows(ValidacaoDataException.class,
                () -> conta01.imprimirExtrato(LocalDate.of(2021, 10, 10),
                        LocalDate.of(2021, 10, 10)));

        Assertions.assertEquals(expectativa, resultado.getMessage());
    }

}
