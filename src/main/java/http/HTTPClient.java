package http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.net.CookieHandler;
import java.net.CookiePolicy;
import okio.ByteString;

public class HTTPClient {

    public static final RequestBody EMPTY_REQUEST_BODY
            = RequestBody.create(MediaType.parse("text/x-markdown; charset=utf-8"), ByteString.EMPTY);

    private String cookie = "PHPSESSID=skoo89n76n5880a0h870edbbk5";

    public String sendGet(String url) throws Exception {

        Request request
                = new Request.Builder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("user-agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/55.0.2883.87 Chrome/55.0.2883.87 Safari/537.36")
                .header("Cookie", cookie)
                .url(HttpUrl.parse(url).newBuilder()
                        .build())
                .build();
        Response response = HttpClientFactory.getClient().newCall(request).execute();
        return response.body().string();

    }

    public void authPost(String username, String password, String url) throws Exception {
        java.net.CookieManager cookieManager = new java.net.CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        Request request
                = new Request.Builder()
                .post(EMPTY_REQUEST_BODY)
                .header("Content-Type", "application/x-www-form-urlencoded")
                // .header("Cookie", cookie)
                .url(HttpUrl.parse(url).newBuilder()
                        .addQueryParameter("username", username)
                        .addQueryParameter("password", password)
                        .build())
                .build();
        Response response = HttpClientFactory.getClient().newCall(request).execute();
        //  cookie = response.header("Set-Cookie").split(";")[0];

    }

}
