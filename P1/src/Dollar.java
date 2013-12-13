

public class Dollar extends MyCurrency {

	public Dollar() {
		super();
	}

	public Dollar(double t1) {
		super(t1);
	}
	
	public boolean isDollar() {
		return true;
	}
	public boolean isPeso(){
		return false;
	}
}