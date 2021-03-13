package com.company;

public class Lamp {
    private String style;
    private boolean hasBattery;
    private int globRating;

    public Lamp(String style, boolean hasBattery, int globRating) {
        this.style = style;
        this.hasBattery = hasBattery;
        this.globRating = globRating;
    }

    public void turnOn(){
        System.out.println("Lamp.turnOn() -> Lamp turned on");
    }

    public String getStyle() {
        return style;
    }

    public boolean isHasBattery() {
        return hasBattery;
    }

    public int getGlobRating() {
        return globRating;
    }
}
