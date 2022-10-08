import model.controlefinanceiro.ContaBancaria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ContaBancaria c1 = new ContaBancaria("3289", "2000", "Guilherme", LocalDate.of(
                2001, 11, 9), BigDecimal.valueOf(500), true);
        ContaBancaria c2 = new ContaBancaria("0010", "4324", "Maria", LocalDate.of(
                2003, 8, 12), BigDecimal.valueOf(500), true);


        System.out.println("Saldo doadora antes: "+ c1.getSaldoDaConta());
        System.out.println("Saldo receptora antes: "+ c2.getSaldoDaConta());

        c1.transferir(BigDecimal.valueOf(200), c2);

        System.out.println("Saldo doadora depois: "+ c1.getSaldoDaConta());
        System.out.println("Saldo receptora depois: "+ c2.getSaldoDaConta());

    }
}
