

public class Account {
	
	User user;
	MyCurrency amount;

	public double getAmount() {
		return amount.getQuantity();
	}

	public Account(User t1, MyCurrency t2) {
		user = t1;
		amount = t2;
	}
}