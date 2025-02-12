import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HealthCheck {
    public static void main(String[] args) throws java.lang.Throwable {
        final URL url = new URI(args[0]).toURL();

        final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        final int exitCode = java.net.HttpURLConnection.HTTP_OK == connection.getResponseCode() ? 0 : 1;
        System.exit(exitCode);
    }
}