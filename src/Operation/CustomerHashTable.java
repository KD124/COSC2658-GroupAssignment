package Operation;

import Model.Customer;

public class CustomerHashTable {
    private final int tableSize = 5000;
    private CustomerNode[] table;
    //below attributes support the partial search
    private final int searchSize = 10;
    private Customer[] searchList;
    private int count;      //keep track of number of search result


    public CustomerHashTable() {
        table = new CustomerNode[this.tableSize];
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
        return (23*s.charAt(0) + 29*s.charAt(1) + 31*s.charAt(2) + 37*s.charAt(3) + 41*s.charAt(4)) % tableSize;
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

    public Customer[] getList(String id){   //return an array of size 10, some elements might be null because the search result may < 10
                                            //return null --> no search found
        //do hashing
        int idx = hash(id);

        if(table[idx] == null){
            return null;
        }

        //setup and renew searchList
        searchList = new Customer[searchSize];
        count = 0;
        //do searching in a specific BST after hashing
        CustomerNode c = table[idx];
        bstSearch(id,c);
        if(count == 0) {
            return null;
        }
        return searchList;
    }

    public void bstSearch(String inputId, CustomerNode c){
        if(count == searchSize){    //reach 10 results --> no need further search
            return ;
        }
        while(c != null){
            int compareResult = compare(inputId,c.getCustomer().getId());
            if (compareResult == 1) {
                c = c.getLeft();
            }
            else if (compareResult == 2) {
                c = c.getRight();
            }
            else {  // id found --> add result to list
                    // and continue searching for both subset of the current node
                searchList[count] = c.getCustomer();
                count++;
                bstSearch(inputId, c.getRight());
                bstSearch(inputId, c.getLeft());
                return;
            }
        }
    }
    //read data from csv file here - return true if succeed and false if not
    //assign the data into appropriate attribute of customer object
    //(no need at the moment) assign student object to correct location in the array (wait for put function to complete to do this step)
    public boolean readData(String fileName){
        return false;
    }
}
