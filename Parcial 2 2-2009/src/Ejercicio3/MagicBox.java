package Ejercicio3;

public class MagicBox {

	public void evaluateBoxes(int dim){
		Integer[] vec = new Integer[dim];
		for(int i = 0; i<dim; i++){
			vec[i] = i;
		}
		checkPermutations(vec, 0,(int)Math.sqrt(dim));
		
	}

	private boolean evaluate(Integer[] vec, int dim){
		Integer sum = null;
		int aux=0;
		for(int i = 0; i<vec.length; i++){
			if(i%dim == 0 && aux != 0){
				if(sum != null && aux != sum){
					return false;
				}else if(sum == null){
					sum = aux;
				}
				aux = 0;
			}
			aux += vec[i];
		}
		for(int i = 0; i<dim; i++){
			aux = 0;
			for(int w = 0; w<dim; w++){
				aux+=vec[i+dim*w];
			}
			if(aux != sum){
				return false;
			}
		}
		int aux2=0;
		aux = 0;
		for(int i = 0; i<dim; i++){
			aux+=vec[i+dim*i];
			aux2+=vec[(i+1)*(dim-1)];
		}
		if(aux != sum||aux2!=sum){
			return false;
		}
		
		return true;
	}
	
	private void print(Integer[] vec){
		for(Integer a: vec){
			System.out.print(a+ " ");
		}
		System.out.println();
	}
	
	private void checkPermutations(Integer[] vec, int pos,int dim){
		if(pos == vec.length){
			if(evaluate(vec, dim)){
				print(vec);
			}
			return;
		}
		for(int i = pos; i<vec.length; i++){
			Integer aux = vec[i];
			vec[i] = vec[pos];
			vec[pos] = aux;
			checkPermutations(vec, pos+1, dim);
			vec[pos] = vec[i];
			vec[i] = aux;
		
		}
	}
	
}
