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

    @DisplayName("Teste para verificar se o valor estar sendo descontado no saldo da conta enviadora")
    @Test
    void verificaSeOValorFoiTiradoDaConta(){

        conta01.transferir(BigDecimal.valueOf(200), conta02);
        BigDecimal expectativa = new BigDecimal(300);
        BigDecimal resultado = conta01.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

    @DisplayName("Teste para verificar se o valor estar sendo depositado no saldo da conta receptora")
    @Test
    void verificaSeOValorFoiDepositadoNaConta(){

        conta01.transferir(BigDecimal.valueOf(200), conta02);
        BigDecimal expectativa = new BigDecimal(700);
        BigDecimal resultado = conta02.getSaldoDaConta();

        Assertions.assertEquals(expectativa, resultado);
    }

}
