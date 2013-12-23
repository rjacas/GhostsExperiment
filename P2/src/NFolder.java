

public class NFolder extends NElem {
	
	private NList list;

	public void moveElem(NElem t1, NFolder t2) {
		if (this.list.remove(t1)) 
			t2.addElem(t1);
	}

	public NFile findFile(String t1) {
		return list.find(t1);
	}

	public void addElem(NElem t1) {
		list.add(t1);
		t1.parent = this;
	}

	public NElem getElem(int t1) {
		return list.get(t1);
	}

	public int getSize() {
		return list.size();
	}

	public NFolder(String t1) {
		super(t1);
		list = new NList();
	}
}