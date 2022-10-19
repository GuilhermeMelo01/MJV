import enums.Notificacao;
import enums.Pais;
import enums.TipoServico;
import model.Cliente;
import model.Contrato;
import model.Enderenco;
import service.CadastroService;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        Enderenco enderenco = new Enderenco("Rua celso Ribeiro", "Shopping",
                "Sao caetano", "Fortaleza","93829042", "CE", Pais.FR);
        Cliente cliente = new Cliente("Guilherme Tavares", "09234924546", enderenco);
        Contrato contrato = new Contrato("4234832748", LocalDateTime.now(), TipoServico.AGUA, Notificacao.SMS, cliente);
        CadastroService.geradorArquivoPosicional(contrato);
        CadastroService.geradorArquivoCSV(contrato);

    }

}
