

public class MyCurrency {
	
	double quantity;
	
	static final int CUR = 100;
	static final int DOLLAR = 101;
	static final int PESO = 102;
	
	public MyCurrency(double t1) {
		quantity = t1;
	}

	public MyCurrency() {
		quantity = 0;
	}

	public double getQuantity() {
		return quantity;
	}
	
	public int getUnit() {
		return CUR;
	}
}