
import java.io.IOException;
import java.lang.InterruptedException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a sua chave para a API do IMDB: ");
		String apiKey = scanner.nextLine();

		// Fazer uma conexão HTTPS e buscar os top 250 filmes.
		String url = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String body = response.body();
			System.out.println("Body:");
			System.out.println();
			System.out.println(body);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		// extrair só os dados que interessam (titulo, poster, classificação)
		// extrair, pegar, parsear...

		// exibir e manipular os dados

		scanner.close();
	}

}
