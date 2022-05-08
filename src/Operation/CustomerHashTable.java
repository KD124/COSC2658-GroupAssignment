package Operation;

import Model.Customer;

public class CustomerHashTable {
    private final int arraySize = 5000;
    private CustomerNode[] table;


    public CustomerHashTable() {
        table = new CustomerNode[this.arraySize];
    }

    public CustomerNode[] getTable() {
        return table;
    }

    public int compare(String input, String id) {   //return 0 if input = id, 1 if input < id, 2 if input > id
        for (int i =0; i<input.length();i++) {
            if(input.charAt(i) > id.charAt(i)) {
                return 2;
            }
            if(input.charAt(i) < id.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

    public int hash(String s){
        return (23*s.charAt(0) + 29*s.charAt(1) + 31*s.charAt(2) + 37*s.charAt(3) + 41*s.charAt(4)) % arraySize;
    }

    public boolean put(Customer customer){  //return false if there is already this input id in database
        int idx = hash(customer.getId());
        CustomerNode node = new CustomerNode(customer);

        if(table[idx] == null){
            table[idx] = node;
            return true;
        }

        CustomerNode parent = null;
        CustomerNode current = table[idx];
        while (current != null) {
            int compareResult = compare(customer.getId(),current.getCustomer().getId());
            if (compareResult == 1) {
                parent = current;
                current = current.getLeft();
            }
            else if (compareResult == 2) {
                parent = current;
                current = current.getRight();
            }
            else return false;      // already exists, can’t insert
        }
        if (compare(customer.getId(),current.getCustomer().getId()) == 1) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        return false;
    }


    public Customer get(String id){
        int idx = hash(id);

        if(table[idx] == null){
            return null;
        }

        CustomerNode c = table[idx];
        while(c != null){
            int compareResult = compare(id,c.getCustomer().getId());
            if (compareResult == 1) {
                c = c.getLeft();
            }
            else if (compareResult == 2) {
                c = c.getRight();
            }
            else return c.getCustomer();      // id found
        }
        return null;
    }

    //read data from csv file here - return true if succeed and false if not
    //assign the data into appropriate attribute of customer object
    //(no need at the moment) assign student object to correct location in the array (wait for put function to complete to do this step)
    public boolean readData(String fileName){
        return false;
    }
}
