

public class NList {

	public void remove(NElem t1) {
		NNode aux = first;
		if (t1 == first.getElem()) {
			first = first.getNext();
		}
		while (aux != null) {
			if (aux.getElem() == t1) {
				if (aux.getPrev() != null)
					aux.getPrev().setNext(aux.getNext());
				if (aux.getNext() != null)
					aux.getNext().setPrev(aux.getPrev());
			}
			aux = aux.getNext();
		}		
	}

	public NElem get(int t1) {
		int count = 1;
		NNode aux = first;
		while (aux != null) {
			if (count == t1)
				return aux.getElem();
			aux = aux.getNext();
			count++;
		}
		return null;
	}

	public void add(NElem t1) {
		if (first == null)
			first = new NNode(t1);
		else {
			NNode aux = first;
			String newName = t1.getName();
			while (aux.getNext() != null) {
				String name = aux.getElem().getName();
				if (name.compareTo(newName) < 0) {
					aux = aux.getNext();
				}
				else
					break;
			}
			NNode newN = new NNode(t1);
			if (aux == first) {
				first = newN;
				first.setNext(aux);
				aux.setPrev(first);
			}
			else {
				if (aux.getNext() != null) {
					newN.setNext(aux.getNext());
					aux.getNext().setPrev(newN);
				}
				aux.setNext(newN);
				newN.setPrev(aux);
			}
		}
	}
	
	private NNode first;

	public NList() {
		first = null;
	}
	
	public int size() {
		int sum = 0;
		NNode aux = first;
		while (aux != null) {
			sum += aux.size();
			aux = aux.getNext();
		}
		return sum;
	}
}

class NNode {
	private NNode next;
	private NNode prev;
	private NElem elem;
	
	public NNode(NElem f) {
		elem = f;
	}
	
	public NElem getElem() {
		return elem;
	}
	
	public NNode getNext() {
		return next;
	}
	
	public NNode getPrev() {
		return prev;
	}
	
	public void setNext(NNode n) {
		next = n;
	}
	
	public void setPrev(NNode p) {
		prev = p;
	}
	
	public int size() {
		return elem.size();
	}
}