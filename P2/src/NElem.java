

public class NElem {

	public String name;
	
	public NFolder parent;

	public NElem(String t1) {
		name = t1;
	}
	
	public int size() {
		return 0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		if (parent != null)
			return parent.getPath() + "/" + name;
		else
			return name;
	}
}