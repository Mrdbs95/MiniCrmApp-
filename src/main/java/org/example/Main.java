package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MiniCrmApp{
    private final Map<String, Customer> store = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new MiniCrmApp().run();
    }

    private void run(){
        while (true){
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addCustomer();
                case "2" -> addEmail();
                case "3" -> addTag();
                case "4" -> addnote();
                case "5" -> showCustomer();
                case "6" -> listAll();
                case "0" -> System.out.println("Bye");
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
        String id = scanner.nextLine();
        System.out.println("Customer name:");
        String name = scanner.nextLine();

        if (store.containsKey(id)) {
            System.out.println("Customer is already registered.");
            return;
        }
        store.put(id, new Customer(id,name));
        System.out.println("Customer added.");
    }

    private void addEmail() {
        System.out.print("Customer ID: ");
        String id = scanner.nextLine().trim();
        Customer c = store.get(id);
        if (c == null) {
            System.out.println("No customer with that ID exists.");
            return;
        }
        System.out.print("Email: ");
        c.addEmail(scanner.nextLine().trim());
        System.out.println("Email added.");
    }

    private void addTag() {
        System.out.println("Customer ID:");
        String id = scanner.nextLine();
        Customer customer = store.get(id);
        if(customer == null) {System.out.println("No customer with that ID exist"); return;}
        System.out.println("Tag: ");
        customer.addTag(scanner.nextLine());
        System.out.println("Tag added.");
    }

    private void addnote() {
        System.out.print("Customer id: ");
        String id = scanner.nextLine().trim();
        Customer c = store.get(id);
        if (c == null) { System.out.println("Not found."); return; }
        System.out.print("Note: ");
        c.addNote(scanner.nextLine());
        System.out.println("Note added.");
    }

    private void showCustomer() {
        System.out.print("Customer -id: ");
        String id = scanner.nextLine();
        Customer c = store.get(id);
        System.out.println(c == null ? "Not found." : c);
    }

    private void listAll() {
        for (Customer c : store.values()) {
            System.out.println(c.id()
                    + " (" + c.name() + ") "
                    + "tags: " + c.tags().size()
                    + " emails: " + c.emails().size()
                    + " notes: " + c.notes().size());
        }
    }
}