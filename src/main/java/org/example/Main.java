package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MiniCrm{
    private final Map<String, Customer> store = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new MiniCrm().run();
    }

    private void run(){
        while (true){
            printMenu();
            String choise = sc.nextLine().trim();
            switch (choise) {
                case "1" -> addCustomer();
                case "2" -> addEmail();
                case "3" -> addTag();
                case "4" -> addnote();
                case "5" -> showCustomer();
                case "6" -> listAll();
                case "0" -> System.out.println("Bye"); return;
                default -> System.out.println("unknown choice");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nMini-CRM");
        System.out.println("1) Add customer");
        System.out.println("2) Add email to customer");
        System.out.println("3) Add tag to customer");
        System.out.println("4) Add note to customer");
        System.out.println("5) Show customer by id");
        System.out.println("6) List all customers");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }

    private void addCustomer() {
        System.out.println("Customer ID:");
        String id = sc.nextLine();
        System.out.println("Customer name:");
        String name = sc.nextLine();
        System.out.println("Customer email:");
        String email = sc.nextLine();

        if (store.containsKey(id)) {
            System.out.println("Customer is already registered.");
            return;
        }
        store.put(id, new Customer(id,name));
        System.out.println("Customer added.");
    }

    
}