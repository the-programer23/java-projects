package com.company;

public class Main {

    public static void main(String[] args) {
        ITelephone fabiansPhone;
        fabiansPhone = new DeskPhone(6964531);
        fabiansPhone.powerOn();
        fabiansPhone.callPhone(6964531);
        fabiansPhone.answer();

        fabiansPhone = new MobilePhone(317840471);
        fabiansPhone.powerOn();
        fabiansPhone.callPhone(317840471);
        fabiansPhone.answer();


    }
}
