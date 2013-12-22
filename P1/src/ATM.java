

public class ATM {
	
	MyCurrency unit;

	public boolean moveMoney(User t1, Account t2, Account t3, double t4) {
		MyCurrency aux1 = t2.amount;
		MyCurrency aux2 = t3.amount;
		double result = 0;
		if (t2.user.equals(t1)) {
			if (aux1.getUnit() == aux2.getUnit()) {
				if (aux1.getUnit() == unit.getUnit()) {
					result = t4;
					if (t4 > aux1.getQuantity())
						result = aux1.getQuantity();
					aux1.quantity = aux1.quantity - result;
					aux2.quantity = aux2.quantity + result;
					return true;
				}
				else {
					double convert = 0;
					if (unit.getUnit() == MyCurrency.PESO)
						convert = t4 / 500;
					else
						convert = t4 * 500;
					result = convert;
					if (convert > aux1.getQuantity())
						result = aux1.getQuantity();			
					aux1.quantity = aux1.quantity - result;
					aux2.quantity = aux2.quantity + result;
					return true;					
				}
			}
			else {
				if (aux1.getUnit() == unit.getUnit()) {
					result = t4;
					if (t4 > aux1.getQuantity())
						result = aux1.getQuantity();
					aux1.quantity = aux1.quantity - result;
					if (aux2.getUnit() == MyCurrency.PESO)
						result = t4 * 500;
					else
						result = t4 / 500;					
					aux2.quantity = aux2.quantity + result;
					return true;
				}
				else {
					double convert = 0;
					if (unit.getUnit() == MyCurrency.PESO)
						convert = t4 / 500;
					else
						convert = t4 * 500;
					result = convert;
					if (convert > aux1.getQuantity())
						result = aux1.getQuantity();			
					aux1.quantity = aux1.quantity - result;
					if (aux2.getUnit() == MyCurrency.PESO)
						result = t4 * 500;
					else
						result = t4 / 500;						
					aux2.quantity = aux2.quantity + result;
					return true;					
				}				
			}
		}
		return false;
	}

	public void depositMoney(User t1, Account t2, double t3) {
		MyCurrency aux = t2.amount;
		if (t2.user.equals(t1)) {
			if (unit.getUnit() == aux.getUnit()) {
				aux.quantity = aux.quantity + t3;
			}
			else {
				double convert = 0;
				if (unit.getUnit() == MyCurrency.PESO)
					convert = t3 / 500;
				else
					convert = t3 * 500;
				aux.quantity = aux.quantity + convert;
			}
		}
	}

	public ATM(MyCurrency t1) {
		unit = t1;
	}

	public MyCurrency getMoney(User t1, Account t2, double t3) {
		MyCurrency aux = t2.amount;
		double result = 0;
		if (t2.user.equals(t1)) {
			if (unit.getUnit() == aux.getUnit()) {
				result = t3;
				if (t3 > aux.getQuantity())
					result = aux.getQuantity();
				aux.quantity = aux.quantity - result;
			}
			else {
				double convert = 0;
				if (unit.getUnit() == MyCurrency.PESO)
					convert = t3 / 500;
				else
					convert = t3 * 500;
				result = convert;
				if (convert > aux.getQuantity())
					result = aux.getQuantity();
				aux.quantity = aux.quantity - result;
				if (unit.getUnit() == MyCurrency.PESO)
					result = result * 500;
				else
					result = result / 500;
			}
			if (unit.getUnit() == MyCurrency.PESO)
				return new Peso(result);
			else
				return new Dollar(result);	
		}
		return unit;
	}
}