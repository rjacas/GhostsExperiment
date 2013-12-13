

public class MyCurrency {

	public double quantity;

	public MyCurrency(double t1) {
		quantity = t1;
	}

	public MyCurrency() {
		quantity = 0;
	}
	
	public boolean isDollar() {
		return false;
	}
	public boolean isPeso(){
		return false;
	}
}