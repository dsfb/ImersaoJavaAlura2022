import java.util.List;

public class ExtratorDeConteudoDaLinguagensAPI implements ExtratorDeConteudo {
	private ExtratorDeConteudoComum extrator = new ExtratorDeConteudoComum();
	
	@Override
	public List<Conteudo> extraiConteudos(String json) {

		return extrator.extraiConteudos(json);

	}

}
