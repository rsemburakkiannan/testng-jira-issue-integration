import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ZephyrAPISample {

    public static void main(String[] args) throws IOException {
        // Personal access token (replace with your own)
        String token = "YOUR_PERSONAL_ACCESS_TOKEN";

        // Base URL of your Jira instance
        String baseUrl = "https://your-jira-instance.atlassian.net";

        // API endpoint to retrieve test information
        String endpoint = "/rest/zapi/latest/test";

        // Test ID of the specific test you want to retrieve (replace with your own)
        String testId = "TEST-123";

        // Construct the API URL
        String url = baseUrl + endpoint + "/" + testId;

        // Create HttpClient
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Create GET request
            HttpUriRequest request = new HttpGet(url);

            // Set the authentication header
            request.setHeader("Authorization", "Bearer " + token);
            request.setHeader("Content-Type", "application/json");

            // Send the request and retrieve the response
            HttpResponse response = httpClient.execute(request);

            // Check the response status code
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Successful request
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Test Information:");
                System.out.println(responseBody);
            } else {
                // Request failed
                System.out.println("Error: " + statusCode + " " + response.getStatusLine().getReasonPhrase());
            }
        }
    }
}
