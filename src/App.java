import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // String URL = "https://api.mocki.io/v2/549a5d8b";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();

        String URL = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudoNasa extrator = new ExtratorDeConteudoNasa();
        
        ClienteHTTP HTTP = new ClienteHTTP();
        String json = HTTP.buscaDados(URL);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var gerador = new GeradorDeStickers();
        
        for (Conteudo conteudo : conteudos) {
            
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeDoArquivo = "saida/" + conteudo.getTitulo() + ".png";

            gerador.cria(inputStream, nomeDoArquivo);
        
            System.out.println();
            System.out.println("Tutulo: " + conteudo.getTitulo());
            System.out.println("Imagem: " + conteudo.getUrlImagem());
            // System.out.println("nota: " +  conteudo.get("imDbRating") + "★");
        }
        System.out.println();
    }
}
