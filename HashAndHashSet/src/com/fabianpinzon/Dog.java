package com.fabianpinzon;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {

        if(this == obj){
            System.out.println("this == obj");
            return true;
        }

        if(obj instanceof Dog){
            System.out.println("obj instanceof Dog");
            String objectName = ((Dog) obj).getName();
            System.out.println(objectName);
            return this.name.equals(objectName);
        }

        return false;
    }
}
