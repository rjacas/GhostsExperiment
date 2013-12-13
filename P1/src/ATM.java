

public class ATM {

	public MyCurrency unit;

	public ATM(MyCurrency t1) {
		unit = t1;
	}

	public MyCurrency getMoney(User u, Account a, double t1) {
		if (a.getUser().equals(u)) {
			MyCurrency aux = a.cash;
			if (unit.isDollar()) {
				if (aux.isDollar()) {
					if (t1 > aux.quantity) {
						double aux2 = aux.quantity;
						aux.quantity = 0;
						return new Dollar(aux2);
					}	
					aux.quantity = aux.quantity - t1; 
					return new Dollar(t1);
				}
				else {
					if ((t1/500) > aux.quantity) {
						double aux2 = aux.quantity;
						aux.quantity = 0;
						return new Dollar(aux2/500);
					}					
					aux.quantity = aux.quantity - (t1/500);
					return new Pesos(t1/500);
				}
			}
			else {
				if (aux.isPeso()) {
					if (t1 > aux.quantity) {
						double aux2 = aux.quantity;
						aux.quantity = 0;
						return new Dollar(aux2);
					}						
					aux.quantity = aux.quantity - t1; 
					return new Pesos(t1);
				}
				else {
					if ((t1*500) > aux.quantity) {
						double aux2 = aux.quantity;
						aux.quantity = 0;
						return new Dollar(aux2*500);
					}					
					aux.quantity = aux.quantity - (t1*500);
					return new Dollar(t1*500);					
				}
			}			
		}
		return unit;
	}
}