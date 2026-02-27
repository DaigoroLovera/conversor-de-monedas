import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) {

        String apiKey = "b2f620ec874aba4f5c345dad";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> respuesta = cliente.send(
                    solicitud,
                    HttpResponse.BodyHandlers.ofString()
            );

            JsonObject json = JsonParser
                    .parseString(respuesta.body())
                    .getAsJsonObject();

            JsonObject rates = json.getAsJsonObject("conversion_rates");

            double ars = rates.get("ARS").getAsDouble();
            double bob = rates.get("BOB").getAsDouble();
            double brl = rates.get("BRL").getAsDouble();

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== Conversor de Monedas ===");
                System.out.println("1) USD → ARS");
                System.out.println("2) USD → BOB");
                System.out.println("3) USD → BRL");
                System.out.println("4) Salir");
                System.out.print("Elija una opción: ");

                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= 3) {
                    System.out.print("Ingrese el monto en USD: ");
                    double monto = scanner.nextDouble();

                    double resultado = 0;

                    switch (opcion) {
                        case 1:
                            resultado = convertir(monto, ars);
                            System.out.println("Resultado: " + monto + " USD = " + resultado + " ARS");
                            break;
                        case 2:
                            resultado = convertir(monto, bob);
                            System.out.println("Resultado: " + monto + " USD = " + resultado + " BOB");
                            break;
                        case 3:
                            resultado = convertir(monto, brl);
                            System.out.println("Resultado: " + monto + " USD = " + resultado + " BRL");
                            break;
                    }
                } else if (opcion != 4) {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }

            } while (opcion != 4);

            System.out.println("Gracias por usar el conversor 😊");
            scanner.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double convertir(double monto, double tasa) {
        return monto * tasa;
    }
}