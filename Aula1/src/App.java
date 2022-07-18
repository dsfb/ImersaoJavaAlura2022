
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
		// Fazer uma conex�o HTTPS e buscar os top 250 filmes.
		String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		URI endereco = URI.create(url);
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(endereco).GET().build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();

		// extrair s� os dados que interessam (titulo, poster, classifica��o)
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
		 * Resposta: deve-se s� trocar a URL para os filmes mais populares.
		 * 
		 * 2. Corrigir e melhorar a sa�da do terminal. (Para treinar a programa��o
		 *  b�sica em Java!)
		 *  
		 * 3. Esconder a chave privada da API do IMDB, com o uso de um arquivo ".ini",
		 *  ou extrair de uma configura��o externa, ou vari�vel de ambiente, para tirar
		 *  ela da URL, at� por quest�es de seguran�a da informa��o: externaliza��o
		 *   da configura��o.
		 *  
		 * 4. Usar outra classe para JSON parsing, at� com o uso de outra biblioteca
		 *  para fazer o JsonParse, mantendo a interface e mudando a implementa��o.
		 *  
		 * 5. Ter outro m�todo para voc� pontuar o filme, ou perguntar para o usu�rio.
		 * 
		 * 
		 */
	}

}
