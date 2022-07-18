
import java.io.IOException;
import java.lang.InterruptedException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import br.com.alura.omnistream.service.json.JsonParser;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Fazer uma conexão HTTPS e buscar os top 250 filmes.
		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		// extrair só os dados que interessam (titulo, poster, classificação)
		// extrair, pegar, parsear...
		JsonParser parser = new  JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

		// exibir e manipular os dados
		/* Teste inicial feito durante a aula:
		System.out.println("size: " + listaDeFilmes.size());
		System.out.println(listaDeFilmes.get(0));
		*/
		// iterando sobre todos os 250 filmes.
		for (Map<String, String> filme : listaDeFilmes) {
			System.out.println(filme.get("title"));
			System.out.println(filme.get("image"));
			System.out.println(filme.get("imDbRating"));
			System.out.println();
		}
		
		/* Desafios da aula:
		 * 
		 * 1. Explorar outro endpoint da API do IMDB.
		 * Resposta: deve-se só trocar a URL para os filmes mais populares.
		 * 
		 * 2. Corrigir e melhorar a saída do terminal. (Para treinar a programação
		 *  básica em Java!)
		 *  
		 * 3. Esconder a chave privada da API do IMDB, com o uso de um arquivo ".ini",
		 *  ou extrair de uma configuração externa, ou variável de ambiente, para tirar
		 *  ela da URL, até por questões de segurança da informação: externalização
		 *   da configuração.
		 *  
		 * 4. Usar outra classe para JSON parsing, até com o uso de outra biblioteca
		 *  para fazer o JsonParse, mantendo a interface e mudando a implementação.
		 *  
		 * 5. Ter outro método para você pontuar o filme, ou perguntar para o usuário.
		 * 
		 * 
		 */
	}

}
