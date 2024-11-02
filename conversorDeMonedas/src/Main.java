import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    private static RespuestaAPI respuestaApi;

    public static void main(String[] args) {
        // Cargar las tasas de cambio de la API
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/1204534cc18b37502c2065bf/latest/CLP"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            respuestaApi = gson.fromJson(json, RespuestaAPI.class);

            if (!"success".equals(respuestaApi.result)) {
                throw new IOException("Error en la respuesta de la API.");
            }

            System.out.println("Tasas de cambio cargadas correctamente.");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener las tasas de cambio.");
            e.printStackTrace();
            return; // Salir del programa si no se pudo cargar la API
        }

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("*******************************************");
            System.out.println("   Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("*******************************************");
            System.out.println("1) Dólar => Peso chileno");
            System.out.println("2) Peso chileno => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("*******************************************");
            System.out.print("Elija una opción válida: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarConversion("USD", "CLP");
                    break;
                case 2:
                    realizarConversion("CLP", "USD");
                    break;
                case 3:
                    realizarConversion("USD", "BRL");
                    break;
                case 4:
                    realizarConversion("BRL", "USD");
                    break;
                case 5:
                    realizarConversion("USD", "COP");
                    break;
                case 6:
                    realizarConversion("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo del conversor de moneda...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }

    private static void realizarConversion(String fromCurrency, String toCurrency) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad en " + fromCurrency + ": ");
        double cantidad = scanner.nextDouble();

        Double tasaFrom = respuestaApi.conversion_rates.get(fromCurrency);
        Double tasaTo = respuestaApi.conversion_rates.get(toCurrency);

        if (tasaFrom == null || tasaTo == null) {
            System.out.println("No se encontró la tasa de conversión para las monedas seleccionadas.");
            return;
        }

        double resultado = (cantidad / tasaFrom) * tasaTo;
        System.out.printf("La cantidad de %.2f %s es igual a %.2f %s\n", cantidad, fromCurrency, resultado, toCurrency);
    }
}
