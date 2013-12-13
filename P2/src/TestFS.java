import org.junit.Test;
import junit.framework.TestCase;


public class TestFS extends TestCase {
	
	NFolder f1;
	NFolder f2;
	NFolder f3;
	NFile n1;
	NFile n2;
	NFile n3;
	NFile n4;
	
	@Override
	protected void setUp() {
		f1 = new NFolder("folder1");
		f2 = new NFolder("folder2");
		f3 = new NFolder("folder3");
		n1 = new NFile("a");
		n2 = new NFile("b");
		n3 = new NFile("c");
		n4 = new NFile("d");
	}
	
	@Test
	public void testCreate() {
		assertEquals(f1.getName(),"folder1");
		assertEquals(f1.size(),0);
		assertEquals(n1.getName(),"a");
	}
	
	@Test
	public void testAddFile() {
		assertEquals(f1.getName(),"folder1");
		assertEquals(f1.size(),0);
		f1.addElem(n1);
		assertEquals(f1.size(),1);
		assertEquals(f1.get(1), n1);
	}
	
	@Test
	public void testAddFileOrdered() {
		assertEquals(f1.getName(),"folder1");
		assertEquals(f1.size(),0);
		f1.addElem(n2);
		assertEquals(f1.size(),1);
		f1.addElem(n1);
		assertEquals(f1.size(),2);
		assertEquals(f1.get(1), n1);
	}
	
	@Test
	public void testAddFolder() {
		assertEquals(f1.size(),0);
		f2.addElem(n1);
		f2.addElem(n2);
		f1.addElem(n3);
		assertEquals(f1.size(),1);
		f1.addElem(f2);
		assertEquals(f1.size(),3);
		assertEquals(f1.get(1), f2);
	}
	
	@Test
	public void testPath() {
		assertEquals(f1.size(),0);
		f2.addElem(n1);
		f2.addElem(n2);
		f1.addElem(n3);
		assertEquals(f1.size(),1);
		f1.addElem(f2);
		assertEquals(f1.size(),3);
		assertEquals(f1.get(1), f2);
		assertEquals(n1.getPath(), "folder1/folder2/a");
		assertEquals(n2.getPath(), "folder1/folder2/b");
		assertEquals(n3.getPath(), "folder1/c");
	}

}
