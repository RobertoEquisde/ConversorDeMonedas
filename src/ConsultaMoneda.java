import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscarMoneda(String baseCode){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/60eee0b74db83891c07f741e/latest/"+baseCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request,HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(),Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("no encontre la moneda");
        }
    }
}
