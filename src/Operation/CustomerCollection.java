package Operation;

import Model.Customer;

//Linked list collection
public class CustomerCollection {
    private CustomerNode head;
    private CustomerNode tail;
    private int length;

    public CustomerCollection() {
        length = 0;
    }

    public CustomerCollection(Customer customer) {
        head = new CustomerNode(customer);
        tail = head;
        length = 1;
    }

    public CustomerNode getHead() {
        return head;
    }

    public void setHead(CustomerNode head) {
        this.head = head;
    }

    public CustomerNode getTail() {
        return tail;
    }

    public void setTail(CustomerNode tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
