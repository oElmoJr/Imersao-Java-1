import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String URL = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(URL);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // System.out.println(body);

        var parcer = new JsonParcer();
        List<Map<String, String>> listaDeFilmes = parcer.parce(body);
        System.out.println(listaDeFilmes.size());
        System.out.println(listaDeFilmes.get(0));

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Tutulo: " + filme.get("title"));
            System.out.println("poster: " + filme.get("image"));
            System.out.println("nota: " +  filme.get("imDbRating") + "★");
            System.out.println();

        }
    }
}
