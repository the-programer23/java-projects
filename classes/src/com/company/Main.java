package com.company;

public class Main {

    public static void main(String[] args) {
	    /*Car porsche = new Car();
	    Car ferrari = new Car();
	    porsche.setModel("911");

        System.out.println(porsche.getModel());*/
        /*SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(5.0);
        calculator.setSecondNumber(4);
        System.out.println("add = " + calculator.getAdditionResult());
        System.out.println("subtract = " + calculator.getSubtractionResult());*/

        /*Person person = new Person();
        person.setFirstName("");
        person.setLastName("");
        person.setAge(-5);
        System.out.println("person age is: " + person.getAge());*/
       /* BankAccount bobsAccount = new BankAccount();
                //("121234", 2000.00, "Bob Smith", "bob@bob.com", 123);
        System.out.println(bobsAccount.getBalance());
        bobsAccount.withdrawal(100.00);
        bobsAccount.deposit(50.00);
        bobsAccount.withdrawal(100.00);
        bobsAccount.deposit(51);
        bobsAccount.withdrawal(100.0);

        BankAccount fabiansAccount = new BankAccount("Fabian", "fabian@email.com", 333222 );
        System.out.println(fabiansAccount.getCustomerName() + " email is " + fabiansAccount.getEmail());*/
      /*  VipCustomer John = new VipCustomer("John", 100000.00, "john@email.com");
         System.out.println(John.getName() + " " + John.getEmail());
        VipCustomer defaultCustomer = new VipCustomer();
        System.out.println(defaultCustomer.getName() + " " + defaultCustomer.getCreditLimit());
        VipCustomer sergio = new VipCustomer("Sergio", 200000.00);
        System.out.println(sergio.getCreditLimit() + " " + sergio.getEmail());*/

       /* Wall kitchenWall = new Wall(0.0, 1.25);
        System.out.println("Area = " + kitchenWall.getArea());*/

       /* Carpet carpet = new Carpet(3.5);
        Floor floor = new Floor(2.75, 4.0);
        Calculator calculator = new Calculator(floor, carpet);
        System.out.println("total = " + calculator.getTotalCost());
        carpet = new Carpet(1.5);
        floor = new Floor(5.4, 4.5);
        calculator = new Calculator(floor, carpet);
        System.out.println("total= " + calculator.getTotalCost());*/

        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        System.out.println("one.real= " + one.getReal());//2
        System.out.println("one.imaginary= " + one.getImaginary());//2
        one.subtract(number);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        number.subtract(one);
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());
    }
}
