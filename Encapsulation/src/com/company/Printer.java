package com.company;

public class Printer {
    private double tonerLevel;
    private int printedPages;
    private boolean duplex;

    public Printer(double tonerLevel, boolean duplex) {
        if(tonerLevel >= 0 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }

        this.printedPages = 0;
        this.duplex = duplex;
    }

    public double fillToner(double tonerAmount){
        if(tonerAmount > 0 && tonerAmount <= 100){
            if(this.tonerLevel + tonerAmount > 100){
                return -1;
            }
            return this.tonerLevel += tonerAmount;
        }else {
            return -1;
        }

    }

    public int print(int pages){
        int pagesToPrint = pages;
        if(this.duplex){
            pagesToPrint = (pages / 2) + (pages % 2);
            System.out.println("Printing in duplex mode");
        }

        this.printedPages += pagesToPrint;
        return pagesToPrint;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getPrintedPages() {
        return printedPages;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
