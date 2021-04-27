package org.syohex.study;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class App {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

        HttpRequest request = HttpRequest.newBuilder()        
            .GET()
            .uri(URI.create("https://syohex.org/"))
            .setHeader("user-agent", "Java11 Async Client")
            .build();

        CompletableFuture<HttpResponse<String>> response =
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        System.out.println(result);
    }
}