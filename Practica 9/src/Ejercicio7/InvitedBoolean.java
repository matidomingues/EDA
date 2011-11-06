package Ejercicio7;

public class InvitedBoolean {

	Boolean[][] data = null;
	
	
	private boolean evaluateComp( Integer[] vec) {
		
		for (int i = 0; i <vec.length / 2; i++) {
			for (int w = i + 1; w < vec.length / 2; w++) {
				if(!data[vec[i]][vec[w]]){
					return false;
				}

			}
		}
		for (int i = vec.length / 2; i < vec.length; i++) {
			for (int w = i + 1; w < vec.length; w++) {
				if(!data[vec[i]][vec[w]]){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean invitedBoolean(Integer[] vec){
		return invitedBoolean(vec, 0);
	}
	
	public boolean invitedBoolean2(Integer[] vec, int step){
		return false;
	}
	
	private void makeGraph(Integer[] vec){
		
		
	}
	
	private boolean invitedBoolean(Integer[] vec, int step){
		if(step == vec.length){
			return evaluateComp(vec);
		}
		for(int i = step+1; i< vec.length; i++){
			Integer swap = vec[step];
			vec[step] = vec[i];
			vec[i] = swap;
			if(invitedBoolean(vec, step+1)){
				return true;
			}
			vec[i] = vec[step];
			vec[step] = swap;
		}
		return false;
	}
}
