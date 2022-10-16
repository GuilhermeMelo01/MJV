import enums.TipoServico;
import model.Cadastro;
import model.Cliente;
import model.Contrato;
import model.Enderenco;
import service.CadastroService;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Enderenco enderenco = new Enderenco("teste", "teste01", "Plamirim", "Caucaia",
                "22002");
        Contrato contrato = new Contrato("9403294432", LocalDateTime.now(), TipoServico.AGUA);
        Cliente cliente = new Cliente("Gui", "0923042423", enderenco);
        Cadastro cadastro = CadastroService.realizarCadastro(cliente, contrato);
//        CadastroService.mensagem(cliente, contrato);
//        System.out.println("+=================");
//        System.out.println(cadastro);

        Locale france = Locale.FRANCE;
        Locale english = Locale.ENGLISH;

        LocalTime localTime = contrato.getAgendamento().toLocalTime();
        LocalDate date = contrato.getAgendamento().toLocalDate();

        DateFormat df = DateFormat.getDateInstance();

        System.out.println();

    }
}
