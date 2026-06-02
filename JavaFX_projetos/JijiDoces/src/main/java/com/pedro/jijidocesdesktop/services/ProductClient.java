package com.pedro.jijidocesdesktop.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.pedro.jijidocesdesktop.configuration.ApiConfig;

public class ProductClient {

    private final HttpClient client = HttpClient.newHttpClient();

    public String getAllProducts() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(ApiConfig.BASE_URL + "/products"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}