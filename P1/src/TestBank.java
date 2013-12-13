import org.junit.Test;
import junit.framework.TestCase;

public class TestBank extends TestCase {
	Account a;
	User u;
	ATM t1;
	ATM t2;
	
	@Override
    protected void setUp() {
		u = new User("Pedrito");
		a = new Account(u, new Dollar(100.0));
		t1 = new ATM(new Dollar());
		t2 = new ATM(new Pesos());
	}
	
	@Test
	public void testCreation() {
		assertEquals(u.getName(),"Pedrito");
		assertEquals(a.getUser(),u);
		assertEquals(a.getAmount(),100.0);
	}
	@Test 
	public void testGetMoney() {
		MyCurrency c = u.getMoney(t1, a, 10.0);
		assertEquals(a.getAmount(), 90.0);
	}
	@Test
	public void testGetTonsOfMoney() {
		MyCurrency c = u.getMoney(t1, a,  200.0);
		assertEquals(c.quantity, 100.0);
		assertEquals(a.getAmount(), 0.0);
	}
	@Test
	public void testGetForeignMoney() {
		MyCurrency c = u.getMoney(t2, a, 20.0);
		assertEquals(c.quantity, 0.04);
		assertEquals(a.getAmount(), 99.96);
	}	
}
