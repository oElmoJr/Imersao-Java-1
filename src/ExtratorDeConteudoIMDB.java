import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos(String json) {
        
        var parcer = new JsonParcer();
        List<Map<String, String>> listaDeAtributos = parcer.parce(json);

        List<Conteudo> conteudos = new ArrayList<>();
        
        for (Map<String, String> atributos : listaDeAtributos) {
            String Titulo = atributos.get("title").replace(":", " -");
            String URLImagem = atributos.get("image");

            var conteudo = new Conteudo(Titulo, URLImagem);
            conteudos.add(conteudo);
        }
        
        return conteudos;
    }
}
