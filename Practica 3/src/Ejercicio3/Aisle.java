package Ejercicio3;

public class Aisle {

	Stack data = new Stack();
	Integer currentOperation = 0;
	Prom elems = new Prom();
	Prom oper = new Prom();	
	
	public void add(Integer time) {
		data.push(time);
	}

	public int size() {
		return data.getsize();
	}

	public int timePass() {
		if (currentOperation == 0) {
			if (data.isEmpty()) {
				return data.getsize();
			} else {
				currentOperation = data.pop();
				oper.add(currentOperation);
			}
		}
		currentOperation--;
		elems.add(data.getsize());
		return data.getsize();
	}
	
	

}
