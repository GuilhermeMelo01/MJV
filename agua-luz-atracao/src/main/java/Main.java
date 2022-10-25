import enums.Notificacao;
import enums.Pais;
import enums.TipoServico;
import model.Cliente;
import model.Contrato;
import model.Enderenco;
import repository.ClienteRepository;
import service.CadastroService;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        Enderenco enderenco = new Enderenco("Rua Paulo Ribeiro", "Shopping",
                "São Matheus", "Fortaleza", "93829042", "CE", Pais.FR);

        Cliente cliente = new Cliente("Guilherme Melo", "23333839422", enderenco);
        Contrato contrato = new Contrato("4234832748", LocalDateTime.now(),
                TipoServico.AGUA, Notificacao.SMS, cliente);

        CadastroService.geradorArquivoPosicional(contrato);
        CadastroService.geradorArquivoCSV(contrato);

        ClienteRepository cp = new ClienteRepository();
        cp.save(cliente);

    }

}
