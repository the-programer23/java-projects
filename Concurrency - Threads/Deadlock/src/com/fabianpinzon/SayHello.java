package com.fabianpinzon;

public class SayHello {
    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");

        new Thread(() -> jane.SayHello(john)).start();

        new Thread(() -> john.SayHello(jane)).start();

    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void SayHello(PolitePerson politePerson){
            System.out.format("%s: hello, %s%n", this.name, politePerson.getName());
            politePerson.SayHelloBack(this);
        }

        public synchronized void SayHelloBack(PolitePerson politePerson){
            System.out.format("%s: hello %s%n", this.name, politePerson.getName());
            System.out.println("===============================");
        }
    }
}
