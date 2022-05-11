package View;

import Model.Customer;
import Operation.CustomerHashTable;

import java.util.Scanner;

public class UI {
    private CustomerHashTable customerList;
    private Customer customer;
    private Scanner scanner = new Scanner(System.in);

    public UI() {
        customerList = new CustomerHashTable();
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pauseScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter key to continue...");
        scanner.nextLine();
    }

    public void RMITMenu() {
        while (true)
        {
            Menu();
            //Option1UI();
            //Option2UI();
            String choice;
            System.out.print("Please choose an option: ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit"))
            {
                System.out.println("Exiting system. Have a good day!");
                break;
            }
        }
    }

    private void Menu() {
        System.out.println("RMIT system operational.");
        System.out.println("Please select an option below:");
        System.out.println("\t\t1. Add custormer.");
        System.out.println("\t\t2. Update customer.");                //
        System.out.println("\t\t3. Search customer.");                // Search for a specific customer
        System.out.println("\t\t4. Search for customers' details.");  // Search for a list of customers with information
                                                                    // included in the query user desired
    }

    private void Option1UI() {
        System.out.println("Add new customer." + "\n" +
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
    }

    private void Option2UI() {
        System.out.println("Update customer's information." + "\n" +
                            "******************");
        System.out.print("Customer: ");
        String update_user = scanner.nextLine();            // take id input that user want to search for
        if (!update_user.equals(""))       // check whether user input anything.
        {
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
        }
    }

    private void option3UI(){
        System.out.println("Search customer's information by ID" + "\n" +
                "******************");
        System.out.println("Enter customer's ID: ");
        String search_id = scanner.nextLine();
        if(!search_id.equals("") && customerList.get(search_id)!=null)
        {
            System.out.println(get(search_id);

        }else System.out.println("Invalid customer.");
    }
    private void option4UI(){
        System.out.println("Search list of customer's information " + "\n" +
                "******************");
        System.out.println("Enter customer's ID: ");
        String identify_id = scanner.nextLine();
        if(!identify_id.equals("")&& customerList.getList(identify_id)!=null)
        {
            System.out.println(customerList.getList(search_id);
        }else System.out.println("No customer is found.");

    }
}

}

