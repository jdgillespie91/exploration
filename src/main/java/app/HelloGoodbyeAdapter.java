package app;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

class HelloGoodbyeAdapter {
    public String get() {
        try {
            return get_();
        } catch (IOException e) {
            return null;
        }
    }

    private String get_() throws IOException {
        CloseableHttpClient httpClient;
        HttpGet get;
        CloseableHttpResponse response;
        HttpEntity entity;

        httpClient = HttpClients.createDefault();
        get = new HttpGet("http://localhost:8000");
        response = httpClient.execute(get);

        entity = response.getEntity();
        entity.getContent();

        try {
            return IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8.name());
        } finally {
            response.close();
        }
    }
}
