

public class Account {
	
	User user;
	MyCurrency cash;

	public double getAmount() {
		return cash.quantity;
	}

	public User getUser() {
		return user;
	}

	public Account(User t1, MyCurrency t2) {
		user = t1;
		cash = t2;
	}
}