package com.fabianpinzon;

public class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }
  /*  @Override
    public boolean equals(Object obj) {
        if(this == obj){
            System.out.println("this == obj");
            return true;
        }

        if(obj instanceof Labrador){
            System.out.println("obj instanceof Labrador");
            String objectName = ((Labrador) obj).getName();
            return this.getName().equals(objectName);
        }

        return false;
    }*/

}
