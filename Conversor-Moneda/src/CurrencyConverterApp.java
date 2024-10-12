
import org.json.JSONObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class CurrencyConverterApp {
    // Lista de monedas disponibles
    private static final String[] currencies = {
        "USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CHF", "MXN"
    };

    // Historial de consultas (máximo 5 consultas)
    private static LinkedList<String> history = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        CurrencyApi currencyApi = new CurrencyApi();

        while (running) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Realizar conversión de moneda");
            System.out.println("2. Ver historial de consultas");
            System.out.println("3. Salir");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performCurrencyConversion(scanner, currencyApi);
                    break;
                case 2:
                    showHistory();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    // Método para realizar la conversión de moneda
    private static void performCurrencyConversion(Scanner scanner, CurrencyApi currencyApi) {
        // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        
        // Solicitar las tasas de cambio
        JSONObject exchangeRates = currencyApi.getExchangeRates();
        if (exchangeRates == null) {
            System.out.println("Error al obtener las tasas de cambio.");
            return;
        }

        // Selección de la moneda de origen
        System.out.println("Seleccione la moneda de origen:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println(i + 1 + ". " + currencies[i]);
        }
        int fromCurrencyIndex = scanner.nextInt() - 1;

        // Selección de la moneda de destino
        System.out.println("Seleccione la moneda de destino:");
        for (int i = 0; i < currencies.length; i++) {
            System.out.println(i + 1 + ". " + currencies[i]);
        }
        int toCurrencyIndex = scanner.nextInt() - 1;

        // Solicitar el monto a convertir
        System.out.print("Ingrese el monto a convertir: ");
        double amount = scanner.nextDouble();

        // Realizar la conversión
        String fromCurrency = currencies[fromCurrencyIndex];
        String toCurrency = currencies[toCurrencyIndex];
        double fromRate = exchangeRates.getJSONObject("rates").getDouble(fromCurrency);
        double toRate = exchangeRates.getJSONObject("rates").getDouble(toCurrency);

        double convertedAmount = (amount / fromRate) * toRate;

        // Mostrar el resultado junto con la hora de la consulta
        String result = String.format("%.2f %s es equivalente a %.2f %s (Consulta realizada en: %s)"
        		+ "Codigo hecho por Jose Rodrigo Rivas Rosas, Octubre del 2024", 
                amount, fromCurrency, convertedAmount, toCurrency, formattedDateTime);
        System.out.println(result);

        // Agregar al historial
        addToHistory(result);
    }

    // Método para mostrar el historial de consultas
    private static void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No hay consultas en el historial.");
        } else {
            System.out.println("Historial de consultas (máximo 5):");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }

    // Método para agregar una consulta al historial
    private static void addToHistory(String result) {
        // Si el historial ya tiene 5 consultas, eliminar la más antigua
        if (history.size() == 5) {
            history.removeFirst();
        }
        // Agregar la nueva consulta al final
        history.add(result);
    }
    
    // Codigo por Rodrigo Rivas , Octubre del 2024
}

