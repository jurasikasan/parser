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

    private String hui = "PHPSESSID=73t3pjh1drk7ibikuj1oodkuk7";

    // HTTP GET request
    public String sendGet(String url) throws Exception {

        Request request
                = new Request.Builder()
//                   
//Host: eco.andromix.eu
//Connection: keep-alive
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Referer: http://eco.andromix.eu/monitor/orders
//Accept-Encoding: gzip, deflate, sdch
//Accept-Language: en-US,en;q=0.8,ru;q=0.6,uk;q=0.4
//Cookie: PHPSESSID=7pstfqe8vg1tan6mckk5b67bm7     
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", hui)
                .header("Upgrade-Insecure-Requests", "1")
                .header("Referer", "http://eco.andromix.eu/monitor/orders")
                .header("Connection", "keep-alive")
                .url(HttpUrl.parse(url).newBuilder()
                        .build())
                .build();
        Response response = HttpClientFactory.getClient().newCall(request).execute();
        return response.body().string();

    }

    public void authPost(String username, String password, String url) throws Exception {
//        java.net.CookieManager cookieManager = new java.net.CookieManager();
//        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
//        CookieHandler.setDefault(cookieManager);

//        Request request1
//                = new Request.Builder()
//                       
//
//               
//                        
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("Connection", "keep-alive")
//                .header("Referer", "http://eco.andromix.eu/monitor/orders")
//                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36")
//                .url(HttpUrl.parse(url).newBuilder()
//                        .build())
//                .build();
//        Response response1 = HttpClientFactory.getClient().newCall(request1).execute();
//     

    
        Request request
                = new Request.Builder()
                .post(EMPTY_REQUEST_BODY)
                        
//Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Accept-Encoding:gzip, deflate
//Accept-Language:en-US,en;q=0.8,ru;q=0.6,uk;q=0.4
//Cache-Control:max-age=0
//Connection:keep-alive
//Content-Length:41
//Content-Type:application/x-www-form-urlencoded
//Host:eco.andromix.eu
//Origin:http://eco.andromix.eu
//Referer:http://eco.andromix.eu/login
//Upgrade-Insecure-Requests:1
//User-Agent:Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Cookie", hui)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                .header("Accept-Encoding","gzip, deflate, sdch")
                .header("Accept-Language","en-US,en;q=0.8,ru;q=0.6,uk;q=0.4")
                .header("Connection", "keep-alive")
                .header("Host","eco.andromix.eu")
                .header("Referer", "http://eco.andromix.eu/monitor/orders")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36")
                .url(HttpUrl.parse(url).newBuilder()
                        .addQueryParameter("username", username)
                        .addQueryParameter("password", password)
                        .build())
                .build();
//        System.out.println(request);
//        System.out.println("request builded");
        Response response = HttpClientFactory.getClient().newCall(request).execute();
           hui = response.header("Set-Cookie").split(";")[0];
    System.out.println(hui);
        System.out.println("code " + response.code());
        
//     redirect to   
//        http://eco.andromix.eu/monitor/orders
//Host: eco.andromix.eu
//Connection: keep-alive
//Cache-Control: max-age=0
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
//Referer: http://eco.andromix.eu/login
//Accept-Encoding: gzip, deflate, sdch
//Accept-Language: en-US,en;q=0.8,ru;q=0.6,uk;q=0.4
//Cookie: PHPSESSID=7pstfqe8vg1tan6mckk5b67bm7





    }

}
