import enums.TipoServico;
import model.Cliente;
import model.Contrato;
import model.Enderenco;
import service.CadastroService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Enderenco e = new Enderenco("teste", "teste01", "Plamirim", "Caucaia",
                "22002");
        Contrato contrato = new Contrato("9403294432", LocalDateTime.now(), TipoServico.AGUA);
        Cliente cliente = new Cliente("Gui", "0923042423", contrato, e);
        CadastroService.cadastrar(cliente);
    }
}
