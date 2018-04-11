import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Problem2 {

	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        AllTransaction transaction = new AllTransaction();
        CustomerList customer = new CustomerList();
		
		String tr;
		while ((tr = in.readLine()) != null) {
			String[] split = tr.split(" ");
			Transaction newTransaction = new Transaction(split[0], split[1], split[2], split[3]);
			transaction.addTransaction(newTransaction);
			customer.addCustomer(newTransaction);
			customer.checkDuplicates();
			customer.printAll();
		}

	}

}

class Customer {
	Set<String> transactionId;
	Set<String> emails;
	Set<String> phones;
	Set<String> cards;
	
	public Customer(String id, String email, String phone, String card){
		transactionId = new TreeSet<String>();
		emails = new TreeSet<String>();
		phones = new TreeSet<String>();
		cards = new TreeSet<String>();
		transactionId.add(id);
		emails.add(email);
		phones.add(phone);
		cards.add(card);
	}
	
	public void addTransactionId(String transactionId) {
		this.transactionId.add(transactionId);
	}

	public Set<String> getTransactionId() {
		return transactionId;
	}
	
	public void addEmail(String email) {
		this.emails.add(email);
	}

	public Set<String> getEmails() {
		return emails;
	}
	
	public void addPhone(String phone) {
		this.phones.add(phone);
	}

	public Set<String> getPhones() {
		return phones;
	}
	
	public void addCard(String card) {
		this.cards.add(card);
	}

	public Set<String> getCards() {
		return cards;
	}
}

class CustomerList {
	ArrayList<Customer> customerList;
	
	public CustomerList() {
		this.customerList = new ArrayList<Customer>();
	}

	public void addCustomer(Transaction transaction) {
		boolean exist = false;
		for(Customer c : this.customerList) {
			if(c.getTransactionId().contains(transaction.id) || 
					c.getEmails().contains(transaction.email) ||
					c.getPhones().contains(transaction.phone) ||
					c.getCards().contains(transaction.card)) {
				c.addTransactionId(transaction.id);
				c.addEmail(transaction.email);
				c.addPhone(transaction.phone);
				c.addCard(transaction.card);
				exist = true;
			}
		}
		if(!exist) {
			this.customerList.add(
					new Customer(transaction.id, 
						transaction.email, 
						transaction.phone, 
						transaction.card));
		}
	}
	
	public void printAll() {
		int custId = 1;
		for(Customer c : customerList) {
			System.out.println( "customer" + custId + ":");
			System.out.print(" transactions: [");
			for(String id : c.getTransactionId()) {
				System.out.print(id + " ");
			}
			System.out.println("]");
			System.out.print(" emails: [");
			for(String email : c.getEmails()) {
				System.out.print(email + " ");
			}
			System.out.println("]");
			System.out.print(" phones: [");
			for(String phone : c.getPhones()) {
				System.out.print(phone + " ");
			}
			System.out.println("]");
			System.out.print(" cards: [");
			for(String card : c.getCards()) {
				System.out.print(card + " ");
			}
			System.out.println("]");
			System.out.println();
			custId++;
		}
	}
	
	public void checkDuplicates() {

		TreeSet<Integer> removedCustomerIndex = new TreeSet<Integer>();
		for(Customer c : this.customerList) {
			for(Customer d : this.customerList) {
				if(c != d && customerList.indexOf(c) < customerList.indexOf(d)) {
					for(String id : d.getTransactionId()) {
						if(c.getTransactionId().contains(id)) {
							addAllItem(c, d);
							removedCustomerIndex.add(customerList.indexOf(d));
						}
					}
					for(String email : d.getEmails()) {
						if(c.getEmails().contains(email)) {
							addAllItem(c, d);
							removedCustomerIndex.add(customerList.indexOf(d));
						}
					}
					for(String phone : d.getPhones()) {
						if(c.getPhones().contains(phone)) {
							addAllItem(c, d);
							removedCustomerIndex.add(customerList.indexOf(d));
						}
					}
					for(String card : d.getCards()) {
						if(c.getCards().contains(card)) {
							addAllItem(c, d);
							removedCustomerIndex.add(customerList.indexOf(d));
						}
					}
				}
			}
		}
		
		
		for(int removed : removedCustomerIndex.descendingSet()) {
			this.customerList.remove(removed);
		}
	}
	
	public void addAllItem(Customer c, Customer d) {
		c.getTransactionId().addAll(d.getTransactionId());
		c.getEmails().addAll(d.getEmails());
		c.getPhones().addAll(d.getPhones());
		c.getCards().addAll(d.getCards());
	}
}

class Transaction {
	String id;
	String email;
	String phone;
	String card;
	
	public Transaction(String id, String email, String phone, String card) {
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.card = card;
	}
}

class AllTransaction {
	ArrayList<Transaction> transactionList;
	
	public AllTransaction(){
		transactionList = new ArrayList<Transaction>();
	}

	public void addTransaction(Transaction newTransaction) {
		transactionList.add(newTransaction);
	}
}