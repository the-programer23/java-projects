package com.fabianpinzon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org/");

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}