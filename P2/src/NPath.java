

public class NPath {
	
	NElem elem;

	public String getRelativePath(NFolder t1) {
		String result = elem.getName();
		NElem aux = elem.parent;
		while (aux != null) {
			if (aux.equals(t1)) {
				result = "./" + result;
				aux = null;
			}
			else {
				result = aux.getName()+ "/" + result;
				aux = aux.parent;
			}
		}
		if (result.indexOf(".") < 0)
			return "";
		else
			return result;
	}

	public String getFullPath() {
		String result = elem.getName();
		NElem aux = elem.parent;
		while (aux != null) {
			result = aux.getName()+ "/" + result;
			aux = aux.parent;
		}
		return result;
	}

	public NPath(NElem t1) {
		elem = t1;
	}
}