package View;

import Model.Customer;
import Operation.CustomerHashTable;

import java.util.Scanner;

public class UI {

    private CustomerHashTable customerList;
    private Scanner scanner = new Scanner(System.in);

    public UI() {
        customerList = new CustomerHashTable();
    }

    public CustomerHashTable getCustomerList() {
        return customerList;
    }

    public void pauseScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter key to continue...");
        scanner.nextLine();
    }

    public void run(String fileName){
        if(!customerList.readData(fileName)) {
            System.out.println("Cannot read file!!!");
            pauseScreen();
            System.exit(0);
        }
        System.out.println("Successfully read file!!!");
        pauseScreen();
        //add code here to become complete UI
        RMITMenu();
    }

    public void RMITMenu() {
        while (true)
        {
            Menu();
            String choice;
            System.out.print("Please choose an option(1->4): ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit"))
            {
                System.out.println("Exiting system. Have a good day!");
                break;
            }
            else if (choice.equalsIgnoreCase("1"))
            {
                Option1UI();
            }
            else if (choice.equalsIgnoreCase(("2")))
            {
                Option2UI();
            }
            else if (choice.equalsIgnoreCase("3"))
            {
                option3UI();
            }
            else if (choice.equalsIgnoreCase("4"))
            {
                option4UI();
            }
            else
            {
                System.out.println("Invalid option.");
            }
            pauseScreen();
        }
    }

    private void Menu() {
        System.out.println("\nRMIT SYSTEM OPERATIONAL.");
        System.out.println("Please select an option below:");
        System.out.println("\t\t1. Add custormer.");
        System.out.println("\t\t2. Update customer.");                //
        System.out.println("\t\t3. Search one customer.");                // Search for a specific customer
        System.out.println("\t\t4. Search list of customers.");  // Search for a list of customers with information
                                                                    // included in the query user desired
    }

    private void Option1UI() {
        Customer customer = new Customer();
        System.out.println("\nADD NEW CUSTOMER" + "\n" +
                            "******************");
        System.out.print("Input an ID number: ");
        customer.setId(scanner.nextLine());
        System.out.print("Input customer's first name: ");
        customer.setFirstName(scanner.nextLine());
        System.out.print("Input customer's last name: ");
        customer.setLastName(scanner.nextLine());
        System.out.print("Input phone number: ");
        customer.setPhone(scanner.nextLine());
        if (!customer.getId().equals("") && !customer.getFirstName().equals("")
                && !customer.getLastName().equals("") && !customer.getPhone().equals(""))
        {
            System.out.println("Customer information:\n"
                    + "ID: " + customer.getId() + "\n"
                    + "First name: " + customer.getFirstName() + "\n"
                    + "Last name: " + customer.getLastName() + "\n"
                    + "Phone: " + customer.getPhone() + "\n");
            System.out.println("Customer added.");
        }
        pauseScreen();
    }

    private void Option2UI() {
        System.out.println("\nUPDATE CUSTOMER." + "\n" +
                            "******************");
        System.out.print("Enter customer's id: ");
        String update_user = scanner.nextLine();            // take id input that user want to search for
        if (!update_user.equals(""))       // check whether user input anything.
        {
            System.out.println("Customer's ID: " + update_user);
            pauseScreen();
            Customer CusID = customerList.get(update_user);        // searching function in table and store them inn CusID
            System.out.print("Please select information you want to update: ");
            String update_category = scanner.nextLine();
            if (update_category.equalsIgnoreCase("first name"))
            {
                System.out.print("First name: ");
                CusID.setFirstName(scanner.nextLine());
            }
            else if (update_category.equalsIgnoreCase("last name"))
            {
                System.out.print("Last name: ");
                CusID.setLastName(scanner.nextLine());
            }
            else if (update_category.equalsIgnoreCase("phone"))
            {
                System.out.print("Phone number: ");
                CusID.setPhone(scanner.nextLine());
            }
            pauseScreen();
        }
    }

    private void option3UI(){
        System.out.println("\nSEARCH ONE CUSTOMER" + "\n" +
                "******************");
        System.out.println("Enter customer's ID: ");
        String search_id = scanner.nextLine();
        if(!search_id.equals("") && customerList.get(search_id)!=null)
        {
            System.out.println(customerList.get(search_id));

        }else System.out.println("Invalid customer.");
    }
    private void option4UI(){
        Customer[] customers;
        System.out.println("\nSEARCH LIST OF CUSTOMERS " + "\n" +
                "******************");
        System.out.println("Enter customer's ID: ");
        String identify_id = scanner.nextLine();
        if(!identify_id.equals("")&& (customers = customerList.getList(identify_id))!=null)
        {
            for(Customer cus: customers){
                if(cus == null) break;
                System.out.println(cus.toString());
            }
        }else System.out.println("No customer is found.");

    }
}


