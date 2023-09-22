import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {

    public static void main(String[] args) {
        try {
            // Prompt the user for input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the base currency amount: ");
            double amount = Double.parseDouble(reader.readLine());

            System.out.print("Enter the target currency (e.g., USD, EUR): ");
            String targetCurrency = reader.readLine().toUpperCase();

            // Make an HTTP GET request to the API to get exchange rates
            String apiKey = "YOUR_API_KEY"; // Replace with your API key
            String apiUrl = "https://api.apilayer.com/exchangerates_data/latest?base=USD&symbols=" + targetCurrency;
            
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                // Read the JSON response
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder jsonResponse = new StringBuilder();
                String line;
                while ((line = responseReader.readLine()) != null) {
                    jsonResponse.append(line);
                }
                responseReader.close();

                // Parse JSON response
                JSONObject exchangeRates = new JSONObject(jsonResponse.toString());
                double conversionRate = exchangeRates.getJSONObject("rates").getDouble(targetCurrency);

                // Perform the conversion
                double convertedAmount = amount * conversionRate;

                // Display the result
                System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
            } else {
                System.out.println("Error: Unable to fetch exchange rates. HTTP Response Code: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
