package com.fabianpinzon;

public class Password {
    private static final int key = 12345678;
    private final int encryptedPassword;

    public Password(int password){
    this.encryptedPassword = encryptDecrypt(password);
    }

    public int encryptDecrypt(int password){
        return password ^ key;
    }

    public final void storePassword(){
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password){
        if(encryptDecrypt(password) == this.encryptedPassword){
            System.out.println("Welcome");
            return true;
        }else {
            System.out.println("Nop, you cannot come in");
            return false;
        }
    }
}
