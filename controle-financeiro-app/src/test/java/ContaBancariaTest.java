import model.ContaBancaria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaBancariaTest {

    ContaBancaria conta01 = new ContaBancaria("3289", "2000", "Guilherme",
            LocalDate.of(2001, 11, 9), BigDecimal.valueOf(500), true);

    ContaBancaria conta02 = new ContaBancaria("0010", "4324", "Maria",
            LocalDate.of(2003, 8, 12), BigDecimal.valueOf(500), true);

    @DisplayName("Teste para verificar se o valor esta sendo descontado no saldo da conta origem")
    @Test
    void verificaSeOValorFoiTiradoDaConta(){

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

    @DisplayName("Teste para verificar se o usuário realizou o saque com sucesso")
    @Test
    void verificaSeOSaqueFoiRealizado() {
        conta01.sacar(BigDecimal.valueOf(100));
        BigDecimal expectativa = new BigDecimal(400);
        BigDecimal resultado = conta01.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se o deposito foi realizado com sucesso")
    @Test
    void verificaSeDepositoFoiRealizado() throws SaldoInsuficienteException {
        conta01.depositar(BigDecimal.valueOf(300));
        BigDecimal expectativa = new BigDecimal(800);
        BigDecimal resultado = conta01.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se conta foi cancelada com sucesso")
    @Test
    void verificaSeAContaFoiCancelada() {
        conta01.cancelarConta(true, "justificativa teste");
        Boolean expectativa = false;
        Boolean resultado = conta01.getStatusDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }
}
