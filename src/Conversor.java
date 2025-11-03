import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public double convertirMoneda (String monedaOrigen, String monedaObjetivo, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5281e4dc2c061c1538d7e137/pair/" + monedaOrigen + "/" + monedaObjetivo);
        HttpClient cliente =HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            String jsonRespuesta = respuesta.body();
            JsonObject jsonObject = JsonParser.parseString(jsonRespuesta).getAsJsonObject();
            double tasaDeConversion = jsonObject.get("conversion_rate").getAsDouble();

            return tasaDeConversion * cantidad;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String obtenerMoneda (int opcion) {
        switch (opcion) {
            case 1: {
                return "USD";
            }
            case 2: {
                return "MXN";
            }
            case 3: {
                return "GBP";
            }
            case 4: {
                return "EUR";
            }
            case 5: {
                return "JPY";
            }
            case 6: {
                return "CHF";
            }
            default: {
                throw new IllegalArgumentException("Opcion de moneda no valida: " + opcion);
            }
        }
    }
}
