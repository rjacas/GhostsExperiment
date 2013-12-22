

public class User {
	
	String name;

	public MyCurrency getMoney(ATM t1, Account t2, double t3) {
		return t1.getMoney(this,t2,t3);
	}

	public User(String t1) {
		name = t1;
	}
}