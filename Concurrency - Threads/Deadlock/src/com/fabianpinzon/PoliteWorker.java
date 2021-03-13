package com.fabianpinzon;

public class PoliteWorker {
    public static void main(String[] args) {
        final Worker pablo = new Worker("Pablo", true);
        final Worker john = new Worker("John", true);

        final SharedResource sharedResource = new SharedResource(pablo);

        new Thread(() -> pablo.work(sharedResource, john)).start();
        new Thread(() -> john.work(sharedResource, pablo)).start();
    }
}
