import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.alura.omnistream.service.json.JsonParser;

public class ExtratorDeConteudoDoIMDB {
	
	public List<Conteudo> extraiConteudos(String json) {
		
		// extrair s� os dados que interessam (titulo, poster, classifica��o)
		// extrair, pegar, parsear...
		JsonParser parser = new  JsonParser();
		List<Map<String, String>> listaDeAtributos = parser.parse(json);

		List<Conteudo> conteudos = new ArrayList<>();

		// popular a lista de conteudos
		// Esta parte varia da parte da classe "ExtratorDeConteudoDaNasa"!
		for (Map<String, String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("image")
					.replaceAll("(@+)(.*).jpg$", "$1.jpg");

			var conteudo = new Conteudo(titulo, urlImagem);

			// � comum, o nome no plural para a lista,
			// e o nome no singular para o objeto! 
			conteudos.add(conteudo);
		}
		
		return conteudos;
	}
	
}
