package Ejercicio8;

public class InvitedBoolean {

	Boolean[][] data = null;
	
	
	private boolean evaluateComp( Integer[] vec, int tables) {
		int pos = 0;
		for(int i = 0; i< tables; i++){
			for(int w = 0; w<vec.length/tables; w++){
				for(int z = 0 ; z<vec.length/tables; z++){
					pos = (vec.length/tables)*i;
					if(z != w && !data[vec[w+pos]][z+pos]){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean invitedBoolean(Integer[] vec){
		int i;
		for(i = 0; !invitedBoolean(vec,0,i); i++);
		System.out.println(i);
		return true;
	}
	
	private boolean invitedBoolean(Integer[] vec, int step, int tables){
		if(step == vec.length){
			return evaluateComp(vec,tables);
		}
		for(int i = step+1; i< vec.length; i++){
			Integer swap = vec[step];
			vec[step] = vec[i];
			vec[i] = swap;
			if(invitedBoolean(vec, step+1,tables)){
				return true;
			}
			vec[i] = vec[step];
			vec[step] = swap;
		}
		return false;
	}
}
