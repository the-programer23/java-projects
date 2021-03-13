package com.company;

public class DeskPhone implements ITelephone {
    private int myPhoneNumber;
    private boolean isRinging;

    public DeskPhone(int myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action needed, the desk phone does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + " on deskPhone");
    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering the phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myPhoneNumber){
            isRinging = true;
            System.out.println("Ring ring");
        }else {
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
