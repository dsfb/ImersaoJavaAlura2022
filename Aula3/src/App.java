
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws Exception {
		// Fazer uma conex�o HTTPS e buscar os top 250 filmes.

	    //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

		String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

		var http = new ClienteHttp();
		String json = http.buscaDados(url);

		// exibir e manipular os dados
		List<Conteudo> conteudos = extrator.extraiConteudos(json);
		
		var geradora = new GeradoraDeFigurinhas();

		for (int i = 0; i < 3; i++) {
			Conteudo conteudo = conteudos.get(i);

			InputStream inputStream =
					new URL(conteudo.getUrlImagem()).openStream();
			String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println(conteudo.getTitulo());
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
