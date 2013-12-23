

public class NElem {
	String name;
	NFolder parent;

	public NPath getPath() {
		return new NPath(this);
	}

	public NElem(String t1) {
		name = t1;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return 0;
	}
	
	public NFile findFile(String t1) {
		if (t1.equals(this.getName()))
			return (NFile) this;
		else
			return null;
	}
}