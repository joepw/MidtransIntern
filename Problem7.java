import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem7 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		CustomerList2 customerList = new CustomerList2();
		int inputLines = Integer.parseInt(in.readLine());
		
		for(int i = 0 ; i < inputLines ; i++) {
			String[] input = in.readLine().split(" ");
			if(input[0].equalsIgnoreCase("add")) {
				customerList.addCustomer(input[1]);
			} else if (input[0].equalsIgnoreCase("find")){
				System.out.println(customerList.findCustomer(input[1]));
			}
		}

	}

}

class CustomerList2 {
	 ArrayList<String> customerList;
	
	public CustomerList2() {
		this.customerList = new ArrayList<String>();
	}

	public ArrayList<String> getListCustomer() {
		return customerList;
	}

	public void setListCustomer(ArrayList<String> customerList) {
		this.customerList = customerList;
	}
	
	public void addCustomer(String customer) {
		customerList.add(customer);
	}
	
	public int findCustomer(String prefix) {
		int count = 0;
		for(String c : customerList) {
			if(c.toLowerCase().startsWith(prefix.toLowerCase())) {
				count++;
			}
		}
		return count;
	}
}