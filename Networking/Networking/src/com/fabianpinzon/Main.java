package com.fabianpinzon;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            // URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            // URI uri = new URI("Hello");
            // absolute uri
            //  URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            //this is a relative uri
            URI baseUri = new URI("http://username:password@mynewserver.com:5000");

            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            //Covert uri to url
            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);

            URI relativizedURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI " + relativizedURI);

         /*   System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("Authority = " + uri.getAuthority());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());*/

        } catch (URISyntaxException e) {
            System.out.println("URI bad syntax " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL malformed " + e.getMessage());
        }
    }
}
