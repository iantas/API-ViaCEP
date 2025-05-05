import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();

        System.out.println("Digite o CEP desejado: ");
        var cep = scanner.nextLine();

        try {
            Endereco endereco = consulta.consultaDeEndereco("06434200");
            System.out.println(endereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.JsonGenerate(endereco);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Aplicação finalizada!");
        }




    }
}