package Ejercicio5;

public class Invited {

	Integer[][] data = null;
	Integer[] bestvalue;
	
	public Invited(int cant, Integer[][] afinity) {
		this.data = afinity;
		bestvalue = new Integer[cant];

	}

	public void arrangeTables(int cant) {
		Integer[] vec = new Integer[cant];
		for(int i = 0; i < cant; i++){
			vec[i] = i;
		}
		disorder(vec, cant, 0,null);
		print(bestvalue);
	}

	private void copy(Integer[] vec){
		for(int i = 0; i<vec.length; i++){
			
			bestvalue[i] = vec[i];
		}
	}
	private int evaluateComp(int cant, Integer[] vec) {
		int sumaTotal = 0;
		for (int i = 0; i < cant / 2; i++) {
			for (int w = i + 1; w < cant / 2; w++) {
				sumaTotal += data[vec[i]][vec[w]];
			}
		}
		for(int i = cant/2; i< cant; i++){
			for(int w = i+1; w<cant; w++){
				sumaTotal+= data[vec[i]][vec[w]];
			}
		}
		return sumaTotal;
	}

	
	private void print(Integer[] vec){
		for(Integer a: vec){
			System.out.print(a);
		}
		System.out.println();
	}
	
	private int disorder(Integer[] vec, int cant, int n, Integer globalmin) {
		if (cant == n) {
			return evaluateComp(cant, vec);
		}
		Integer aux = null;
		for (int i = n; i < cant; i++) {
			int swap = vec[n];
			vec[n] = vec[i];
			vec[i] = swap;
			aux = disorder(vec, cant, n + 1, globalmin);
			
			if (globalmin == null || globalmin < aux) {
				copy(vec);
				globalmin = aux;
			}
			vec[i] = vec[n];
			vec[n] = swap;
		}
		return globalmin;
	}
}
