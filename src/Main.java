import Operation.CustomerNode;
import View.UI;

public class Main {
	public static void main(String[] args) {
		String fileName = "customers.csv";
		UI ui = new UI();
		ui.run(fileName);

		//from this is testing the hash function
		int count = 0;
		for(CustomerNode node : ui.getCustomerList().getTable()){
			if(node == null) {
				count++;
			}
		}
		System.out.println(count);
	}
}
