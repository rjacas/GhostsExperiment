import org.junit.Test;
import junit.framework.TestCase;


public class TestFileSystem extends TestCase {
	
	NFolder f1;
	NFolder f2;
	NFolder f3;
	NFile n1;
	NFile n2;
	NFile n3;
	
	@Override
	protected void setUp() {
		f1 = new NFolder("folder1");
		f2 = new NFolder("folder2");
		f3 = new NFolder("folder3");
		n1 = new NFile("a");
		n2 = new NFile("b");
		n3 = new NFile("c");
	}
	
	@Test
	public void testAddFile() {
		assertEquals(f1.getSize(),0);
		f1.addElem(n1);
		assertEquals(f1.getSize(),1);
		assertEquals(f1.getElem(1), n1);
	}
	
	@Test
	public void testAddFileOrdered() {
		assertEquals(f1.getSize(),0);
		f1.addElem(n2);
		assertEquals(f1.getSize(),1);
		f1.addElem(n1);
		assertEquals(f1.getSize(),2);
		assertEquals(f1.getElem(1), n1);
	}
	
	@Test
	public void testAddFolder() {
		f2.addElem(n1);
		f2.addElem(n2);
		f1.addElem(n3);
		assertEquals(f1.getSize(),1);
		assertEquals(n2.getPath().getFullPath(), "folder2/b");
		f1.addElem(f2);
		assertEquals(f1.getSize(),3);
		assertEquals(f1.getElem(1), f2);
		assertEquals(n2.getPath().getFullPath(), "folder1/folder2/b");
	}

	@Test
	public void testFind() {
		f2.addElem(n1);
		f2.addElem(n2);
		f1.addElem(n3);
		f1.addElem(f2);
		assertEquals(f1.findFile("c"), n3);
		assertEquals(f1.findFile("b"), n2);
		assertEquals(f1.findFile("x"), null);
	}	
	
	@Test
	public void testPath() {
		f3.addElem(n3);
		f2.addElem(n2);
		f1.addElem(n1);
		assertEquals(n2.getPath().getFullPath(), "folder2/b");
		assertEquals(n3.getPath().getFullPath(), "folder3/c");
		assertEquals(n2.getPath().getRelativePath(f2), "./b");
		assertEquals(n2.getPath().getRelativePath(f3), "");
		assertEquals(n3.getPath().getRelativePath(f3), "./c");
		f1.addElem(f2);
		f2.addElem(f3);
		assertEquals(n2.getPath().getFullPath(), "folder1/folder2/b");
		assertEquals(n3.getPath().getFullPath(), "folder1/folder2/folder3/c");
		assertEquals(n2.getPath().getRelativePath(f2), "./b");
		assertEquals(n2.getPath().getRelativePath(f3), "");
		assertEquals(n3.getPath().getRelativePath(f3), "./c");
	}

	@Test
	public void testMove() {
		f1.addElem(n1);
		f2.addElem(n2);
		f3.addElem(n3);
		f1.addElem(f3);
		assertEquals(n1.getPath().getFullPath(), "folder1/a");
		assertEquals(n2.getPath().getFullPath(), "folder2/b");
		assertEquals(n3.getPath().getFullPath(), "folder1/folder3/c");
		f1.moveElem(n1,f2);
		assertEquals(f2.getSize(),2);
		f3.moveElem(n1,f2);
		assertEquals(f2.getSize(),2);
		f1.moveElem(f3,f2);
		assertEquals(n1.getPath().getFullPath(), "folder2/a");
		assertEquals(n2.getPath().getFullPath(), "folder2/b");
		assertEquals(n3.getPath().getFullPath(), "folder2/folder3/c");
	}
	
}
