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
                "São Jorge", "Fortaleza", "93829042", "CE", Pais.BR);

        Cliente cliente = new Cliente("Marcelo Tavares", "09238434546", enderenco);
        Contrato contrato = new Contrato("4234832748", LocalDateTime.now(),
                TipoServico.AGUA, Notificacao.SMS, cliente);

        CadastroService.geradorArquivoPosicional(contrato);
        CadastroService.geradorArquivoCSV(contrato);

    }

}
