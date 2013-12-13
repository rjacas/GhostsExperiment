

public class Pesos extends MyCurrency {

	public Pesos() {
		super();
	}
	
	public Pesos(double v) {
		super(v);
	}
	public boolean isDollar() {
		return false;
	}
	public boolean isPeso(){
		return true;
	}
}