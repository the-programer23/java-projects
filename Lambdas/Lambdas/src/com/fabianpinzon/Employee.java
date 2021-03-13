package com.fabianpinzon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Employee jhon = new Employee("Jhon Doe", 30);
        Employee fabian = new Employee("Fabian Pinzon", 31);
        Employee tim = new Employee("Tim Buchalka", 53);
        Employee snow = new Employee("Snow White", 23);

        List<Employee> employees = new ArrayList<>();

        employees.add(jhon);
        employees.add(fabian);
        employees.add(tim);
        employees.add(snow);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        anotherClass.printValue();

        /*Collections.sort(employees, new Comparator<Employee>() {
            @Override

            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });*/

        /*Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));*/

        //sorts employees List in ascending order
        employees.sort(Comparator.comparing(Employee::getName));

        for (Employee employee : employees){
            System.out.println(employee.getName());
        }

        /*String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("s1 " +s1);
                System.out.println("s2 " + s2);
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);*/

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2){
        System.out.println("s1 " + s1);
        return uc.upperAndConcat(s1, s2);
    }
}

interface UpperConcat{
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething(){
       /* UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };*/

        int i = 0;
        i++;

        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };


        return Employee.doStringStuff(uc, "String1", "String2");
       /* {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    return s1.toUpperCase() + s2.toUpperCase();
                }
            };
            System.out.println("AnotherClass class name is " + getClass().getSimpleName());
            i++;
            System.out.println("i = " + i);
            return Employee.doStringStuff(uc, "String1", "String2");
        }*/


        /*System.out.println("The AnotherClass class name is " + getClass().getSimpleName());
        return Employee.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {

                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");*/
    }

    public void printValue(){
        int number = 25;

        Runnable r = () -> {
          try{
              Thread.sleep(5000);
          }catch (InterruptedException e){
              e.printStackTrace();
          }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}
