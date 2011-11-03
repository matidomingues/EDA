package Ejercicio5;

import java.util.Arrays;

public class Invited {

	Integer[][] data = null;
	Integer[] bestvalue;

	public Invited(int cant, Integer[][] afinity) {
		this.data = afinity;
		bestvalue = new Integer[cant];

	}

	public void arrangeTables(int cant) {
		Integer[] vec = new Integer[cant];
		for (int i = 0; i < cant; i++) {
			vec[i] = i;
		}
		disorder(vec, cant, 0, null);
		print(bestvalue);
	}

	private void copy(Integer[] vec) {
		for (int i = 0; i < vec.length; i++) {

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
		for (int i = cant / 2; i < cant; i++) {
			for (int w = i + 1; w < cant; w++) {
				sumaTotal += data[vec[i]][vec[w]];
			}
		}
		return sumaTotal;
	}

	private void print(Integer[] vec) {
		for (Integer a : vec) {
			System.out.print(a+ " ");
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

	private Integer[] getRest(Integer[] vec, Integer[] vec2){
		Integer[] vec3 = new Integer[vec2.length];
		boolean add;
		int pos = 0;
		for(int w = 0; w< vec.length; w++){
			add = true;
			for(int i =0; i<vec2.length; i++){
				if(vec[w] == vec[i]){
					add = false;
					break;
				}
			}
			if(add){
				vec3[pos++] = vec[w];
			}
			
		}
		return vec3;
	}
	
	
	

	private int evaluate(Integer[] vec, Integer[] vec2) {
		Integer[] vec3 = getRest(vec, vec2);
		int sumValue = 0;
		for (int i = 0; i < vec2.length; i++) {
			for (int w = 0; w < vec2.length; w++) {
				if(i != w){
					sumValue += data[vec2[i]][vec2[w]];
					sumValue += data[vec3[i]][vec3[w]];
				}
			}
		}
		return sumValue;
	}

	public int disorder2(Integer[] vec){
		Integer[] vec2 = new Integer[(int)(vec.length/2)];
		return disorder2(vec, vec2, 0, 0);
	}
	
	private int disorder2(Integer[] vec, Integer[] vec2, int pos, int loc) {
		if (pos == (int) (vec.length / 2)) {
			int eval = evaluate(vec, vec2);
			System.out.println(eval);
			print(vec2);
			return eval;
		}
		int aux;
		Integer localmax = null;
		for (int i = loc; i < vec.length; i++) {
			vec2[pos] = vec[i];
			aux = disorder2(vec, vec2, pos + 1, i+1);
			if (localmax == null || localmax < aux) {
				localmax = aux;
			}

		}
		System.out.println(loc + " " + localmax + " " + pos );
		return localmax;
	}

}
