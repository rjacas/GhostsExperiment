

public class User {
	private String name;
	
	public User(String t1) {
		name = t1;
	}
	
	public MyCurrency getMoney(ATM t1, Account a, double t2) {
		return t1.getMoney(this, a, t2);
	}

	public String getName() {
		return name;
	}

}