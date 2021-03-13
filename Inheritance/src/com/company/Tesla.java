package com.company;

public class Tesla extends Car{
    private int roadServiceMoth;

    public Tesla(int roadServiceMoth) {
        super("Tesla Model 3", "4WD", 2, 4, 5, true);
        this.roadServiceMoth = roadServiceMoth;
    }

    public void accelerate(int rate){
        int newVelocity = getCurrentVelocity() + rate;

        if(newVelocity == 0){
            stop();
            changeGear(1);
        }else if(newVelocity > 0 && newVelocity <=10){
            changeGear(2);
        }else if(newVelocity > 20 && newVelocity <= 30){
            changeGear(3);

        }else {
            changeGear(4);
        }

        if(newVelocity > 0){
            changeVelocity(newVelocity, getCurrentDirection());
        }

    }
}
