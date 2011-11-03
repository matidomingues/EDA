package Ejercicio6;

import java.util.LinkedList;
import java.util.List;

public class InvitedHillClimbing {

	Integer[][] data = null;
	Integer[] bestvalue;

	public InvitedHillClimbing(int cant, Integer[][] afinity) {
		this.data = afinity;
		bestvalue = new Integer[cant];

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

	private Integer[] clone(Integer[] data) {
		Integer[] aux = new Integer[data.length];
		for (int i = 0; i < data.length; i++) {
			aux[i] = data[i];
		}

		return aux;
	}

	private List<Integer[]> neighbours(Integer[] data) {
		List<Integer[]> aux = new LinkedList<Integer[]>();
		for (int i = 0; i < data.length / 2; i++) {
			for (int w = data.length / 2; w < data.length; w++) {
				Integer[] newvec = clone(data);
				newvec[i] = data[w];
				newvec[w] = data[i];
				aux.add(newvec);
			}
		}
		return aux;
	}

	private void swapall(Integer[] vec) {
		for (int i = 0; i < 100; i++) {
			int rand = (int) (Math.random() * vec.length);
			Integer aux = vec[rand];
			vec[rand] = vec[i % vec.length];
			vec[i % vec.length] = aux;
		}
	}

	private void print(Integer[] vec) {
		for (Integer a : vec) {
			System.out.print(a);
		}
		System.out.println();
	}

	public void hillClimbing(Integer[] vec) {
		int t = 0;
		Integer[] localmin = null;
		boolean local;
		bestvalue = null;
		while (t != 100) {
			local = false;
			localmin = clone(vec);
			swapall(localmin);
			boolean entered = false;
			while (!local) {
				entered = false;
				for (Integer[] a : neighbours(localmin)) {
					if (localmin == null || evaluateComp(a.length, a) > evaluateComp(
									localmin.length, localmin)) {
						localmin = a;
						entered = true;
						System.out.println("changed localmin");
					}
				}
				if (!entered) {
					local = true;
				}
			}
			if (bestvalue == null
					|| evaluateComp(localmin.length, localmin) > 
			evaluateComp(bestvalue.length, bestvalue)) {
				bestvalue = localmin;
			}
			t += 1;
		}

		print(bestvalue);
	}

}
