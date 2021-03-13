package com.fabianpinzon;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApacheTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.org");
        request.addHeader("User-agent", "Chrome");

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("Response code = " + response.getCode());

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line;

            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();

        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}
