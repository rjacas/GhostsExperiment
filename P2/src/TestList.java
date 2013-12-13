import org.junit.Test;
import junit.framework.TestCase;

public class TestList extends TestCase {
	
	NList l;
	NFile f1;
	NFile f2;
	NFile f3;

	@Override
	protected void setUp() {
		l = new NList();
		f1 = new NFile("holi");
		f2 = new NFile("a");
		f3 = new NFile("h");
	}

	@Test
	public void testCreate() {
		assertEquals(f1.getName(), "holi");
	}	
	
	@Test
	public void testBasicAdd() {
		assertTrue(l.size() == 0);
		l.add(f1);
		assertTrue(l.size() == 1);
		assertEquals(l.get(1),f1);
	}
	
	@Test
	public void testAddRemove() {
		assertTrue(l.size() == 0);
		l.add(f1);
		assertTrue(l.size() == 1);
		assertEquals(l.get(1),f1);
		l.remove(f1);
		assertTrue(l.size() == 0);
	}
	
	@Test
	public void testAddOrdered() {
		assertTrue(l.size() == 0);
		l.add(f1);
		assertTrue(l.size() == 1);
		l.add(f2);
		assertTrue(l.size() == 2);
		assertEquals(l.get(1),f2);
		assertEquals(l.get(2),f1);
	}

}
