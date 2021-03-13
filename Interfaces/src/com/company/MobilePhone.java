package com.company;

public class MobilePhone implements ITelephone {

    private int myPhoneNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile phone powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("Now ringing " + phoneNumber + " on mobile phone");
        }else {
            System.out.println("Phone is switched off");
        }

    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myPhoneNumber && isOn){
            isRinging = true;
            System.out.println("Melody ring");
        }else {
            isRinging = false;
            System.out.println("Mobile phone not on or phone number different");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
