package Ejercicio3;

public class BooleanEvaluator {
	
	public static void returnTrue(int dim){
		boolean[] vec = new boolean[dim];
		returnTrue(vec,dim,0);
	}
	
	public static void print(boolean[] vec){
		for(boolean a: vec){
			System.out.print(a+ " ");
		}
		System.out.println();
	}
	
	private static void returnTrue(boolean[] vec, int dim, int loc){
		if(loc == dim){
			if(EDAUtils.evaluate(vec)){
				print(vec);
				return;
			}
			return;
		}
		vec[loc] = true;
		returnTrue(vec,dim,loc+1);
		vec[loc] = false;
		returnTrue(vec,dim,loc+1);
	}
	
	public static void main(String[] args){
		returnTrue(3);
	}
}
