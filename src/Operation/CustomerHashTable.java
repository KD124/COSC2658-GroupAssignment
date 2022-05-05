package Operation;

import Model.Customer;

public class CustomerHashTable {
    private final int arraySize = 10000;
    private CustomerCollection[] table;


    public CustomerHashTable() {
        table = new CustomerCollection[this.arraySize];
    }

    public CustomerCollection[] getTable() {
        return table;
    }

    public int hash(String s){
        return 0;
    }

    public boolean put(Customer customer){
        return false;
    }

    public Customer get(String id){
        return null;
    }

    //read data from csv file here - return true if succeed and false if not
    //assign the data into appropriate attribute of customer object
    //(no need at the moment) assign student object to correct location in the array (wait for put function to complete to do this step)
    public boolean readData(String fileName){
        return false;
    }
}
