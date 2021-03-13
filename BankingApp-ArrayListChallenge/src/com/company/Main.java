package com.company;

public class Main {

    public static void main(String[] args) {
	    Bank bank = new Bank("Bancolombia");

	    if(bank.addBranch("Real de minas")){
			System.out.println("Real de minas branch created");
		};

	    bank.addCustomer("Real de minas", "Fabian", 1000.50);
	    bank.addCustomer("Real de minas", "Carlos", 578.23);
	    bank.addCustomer("Real de minas", "Sergio", 250.30);

	    bank.addBranch("Cabecera");
	    bank.addCustomer("Cabecera", "Nestor", 2350.48);

	    bank.addCustomerTransaction("Real de minas", "Fabian", 250.26);
	    bank.addCustomerTransaction("Real de minas", "Fabian", 874.98);
	    bank.addCustomerTransaction("Real de minas", "Carlos", 250.44);

	    bank.addCustomerTransaction("Cabecera", "Nestor", 850.88);

	    bank.listCustomers("Real de minas", false);
	    bank.listCustomers("Cabecera", true);

	    bank.addBranch("Centro");
	    if(!bank.addCustomer("Centro", "Juan", 250.00)){
			System.out.println("The branch Centro does not exist");
		}
	    if(!bank.addBranch("Cabecera")){
			System.out.println("Cabecera branch already exists");
		}
	    if(!bank.addCustomerTransaction("Real de minas", "Pepito", 1028.22)){
			System.out.println("Customer does not exist at branch");
		}
	    if(!bank.addCustomer("Real de minas", "Fabian", 1240.22)){
			System.out.println("Customer Fabian already exists");
		}
    }
}
