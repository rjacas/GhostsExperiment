
public class NNode {
	NNode prev;
	NNode next;
	NElem file;
	NNode getPrev() {
		return prev;
	}
	NNode getNext() {
		return next;
	}
	public NNode(NElem t1) {
		file = t1;
	}
	public NElem getElem() {
		return this.file;
	}
	public void setNext(NNode t1) {
		next = t1;
	}
	
	public void setPrev(NNode t1) {
		prev = t1;
	}
	
	public int size() {
		return file.getSize();
	}

}
