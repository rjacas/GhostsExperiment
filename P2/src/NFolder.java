

public class NFolder extends NElem {
	
	private NList list;

	public NElem get(int t1) {
		return list.get(t1);
	}

	public void addElem(NElem t1) {
		t1.parent = this;
		list.add(t1);
	}

	public String getName() {
		return name;
	}

	public NFolder(String t1) {
		super(t1);
		list = new NList();
	}

	public int size() {
		return list.size();
	}
}