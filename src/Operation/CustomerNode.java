package Operation;

import Model.Customer;

public class CustomerNode {
    private Customer customer;
    private CustomerNode next;

    public CustomerNode(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerNode getNext() {
        return next;
    }

    public void setNext(CustomerNode next) {
        this.next = next;
    }
}
