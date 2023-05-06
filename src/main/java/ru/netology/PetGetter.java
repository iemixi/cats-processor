package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class PetGetter {
    private final CloseableHttpClient httpClient;
    private final String resourceUrl;

    public PetGetter(String resourceUrl) {
        this.resourceUrl = resourceUrl;

        this.httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
    }

    public List<Pet> get() {
        HttpGet request = new HttpGet(resourceUrl);
        try {
            String responseBody = EntityUtils.toString(httpClient.execute(request).getEntity(), "UTF-8");

            return new ObjectMapper().readValue(responseBody, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
