import org.junit.Test;
import junit.framework.TestCase;

public class TestAccounts extends TestCase {
	Account a, b; 
	User u1, u2;
	ATM t1;
	ATM t2;
	
	@Override
    protected void setUp() {
		u1 = new User("Pedrito");
		u2 = new User("Pepito");
		a = new Account(u1, new Dollar(100.0));
		b = new Account(u2, new Peso(50000));
		t1 = new ATM(new Dollar());
		t2 = new ATM(new Peso());
	}
	
	@Test 
	public void testGetMoney() {
		MyCurrency c = u1.getMoney(t1, a, 10.0);
		assertEquals(c.getQuantity(), 10.0);
		assertEquals(a.getAmount(), 90.0);
	}
	@Test
	public void testGetTonsOfMoney() {
		MyCurrency c = u1.getMoney(t1, a,  200.0);
		assertEquals(c.getQuantity(), 100.0);
		assertEquals(a.getAmount(), 0.0);
	}
	@Test
	public void testGetDollarFromPeso() {
		MyCurrency c = u2.getMoney(t1, b, 20.0);
		assertEquals(c.getQuantity(), 20.0);
		assertEquals(b.getAmount(), 40000.0);
	}
	@Test
	public void testGetPesoFromDollar() {
		MyCurrency c = u1.getMoney(t2, a, 20.0);
		assertEquals(c.getQuantity(), 20.0);
		assertEquals(a.getAmount(), 99.96);
	}
	@Test
	public void testDepositDollarFromPeso() {
		t1.depositMoney(u2, b, 20.0);
		assertEquals(b.getAmount(), 60000.0);
	}
	@Test
	public void testDepositPesoFromDollar() {
		t2.depositMoney(u1, a, 20.0);
		assertEquals(a.getAmount(), 100.04);
	}
	@Test
	public void testMoveFromPesoToDollarInPeso() {
		boolean result = t2.moveMoney(u2, b, a, 20.0);
		assertTrue(result);
		assertEquals(a.getAmount(), 100.04);
		assertEquals(b.getAmount(), 49980.0);
	}
}
