package com.company;

public class ComplexNumber {
    private double real;//1.0, 2.5
    private double imaginary;//1.0, -1.5

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void add (double real, double imaginary){
        this.real = (real + this.real); //2,
        this.imaginary = (imaginary + this.imaginary);//2,
    }

    public void add (ComplexNumber complexNumber){
        this.imaginary = (complexNumber.imaginary + this.imaginary);
        this.real = (complexNumber.real + this.real);
    }

    public void subtract (double real, double imaginary) {
        this.real = (this.real - real);
        this.imaginary = (this.imaginary - imaginary);
    }

    public void subtract (ComplexNumber complexNumber){
        this.imaginary = (this.imaginary - complexNumber.imaginary);
        System.out.println("this.imaginary= " + this.imaginary);//this.imaginary = 3.5
        this.real = (this.real - complexNumber.real);
    }
}
