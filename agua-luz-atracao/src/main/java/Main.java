import enums.Notificacao;
import enums.Pais;
import enums.TipoServico;
import model.Cliente;
import model.Contrato;
import model.Enderenco;
import service.CadastroService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Enderenco enderenco = new Enderenco("Rua celso Ribeiro", "Bar Local", "JUQUEIRA",
                "Caucaia","93829042", "CE", Pais.BR);
        Cliente cliente = new Cliente("Guilherme Tavares", "09234924546", enderenco);
        Contrato contrato = new Contrato("4234832748", LocalDateTime.now(), TipoServico.AGUA, Notificacao.SMS);
        CadastroService.geradorArquivoPosicional(cliente, contrato);
        CadastroService.geradorArquivoCSV(cliente, contrato);

    }

}
