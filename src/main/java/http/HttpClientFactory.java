
package http;

import com.squareup.okhttp.OkHttpClient;
import java.net.CookieHandler;
import java.net.CookiePolicy;

final class HttpClientFactory {

    private static OkHttpClient client;

    private HttpClientFactory() {
    }

    public static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();          
            client.setCookieHandler(CookieHandler.getDefault());
        }
        return client;
    }
}
