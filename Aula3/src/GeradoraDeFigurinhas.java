import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;;

public class GeradoraDeFigurinhas {
	// via polimorfismo, passa-se um InputStream que represente bytes vindos de qualquer
	// fonte de dados, seja ela um arquivo, um socket na web, ou um bytearray, etc.
	// Poderia-se passar a String da URL, mas passando o InputStream, fica mais
	// flexível, ainda!
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
		// leitura da imagem
		// link da imagem menor:
		// https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg
		// link da imagem maior:
		// https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@.jpg
		// Na linha abaixo o input stream, vem do arquivo salvo na pasta deste projeto!
		//InputStream inputStream = 
		//                 new FileInputStream("entrada/filme-maior.jpg");
		// Agora, o input stream vai vir direto da url, conforme a url foi declarada
		//   nas linhas mais acima!
		/*String url = "https://m.media-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@.jpg";
		InputStream inputStream = 
				new URL(url).openStream();*/
		BufferedImage imagemOriginal = ImageIO.read(inputStream);
		
		// cria nova image em memória com transparência e com tamanho novo
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200; // Nova altura é a altura original + 200 pixels.
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura,
				BufferedImage.TRANSLUCENT);

		// copiar a imagem original para nova imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		// começa a desenhar da imagem original na nova imagem (mais alta!)
		// e começa do ponto P(0, 0), onde os zeros já foram passados, também!
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		// configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setFont(fonte);
		graphics.setColor(Color.YELLOW);
		
		// escrever uma frase na nova imagem.
		// a partir do objeto "graphics" que é a nossa caneta! ;)
		graphics.drawString("TOPZERA", 178, altura + 100);
		
		// escrever a nova imagem em um arquivo.
		// como a imagem tem transparência, então o formato só pode ser: "PNG".
		// mas se a imagem não tivesse transparência, então seria o formato: "JPG".
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	}
	
}
