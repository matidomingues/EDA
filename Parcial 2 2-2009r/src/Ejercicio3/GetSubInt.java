package Ejercicio3;

public class GetSubInt {

	private int evaluate(Integer[] vec2, int sum) {
		for (int i = 0; i < vec2.length; i++) {
			if (vec2[i] == null) {
				return 1;
			}
			sum -= vec2[i];
			if (sum == 0) {
				return 0;
			} else if (sum < 0) {
				return -1;
			}
		}
		return 1;
	}
	
	private void print(Integer[] vec2){
		for(int i = 0; i< vec2.length; i++){
			if(vec2[i] == null){
				System.out.println();
				return;
			}
			System.out.print(vec2[i]);
		}
		System.out.println();
	}

	public void getSum(Integer[] vec, int sum){
		Integer[] vec2 = new Integer[vec.length];
		printSum(vec, vec2, sum, 0, 0);
	}
	
	private void printSum(Integer[] vec, Integer[] vec2, int sum, int loc,
			int pos) {
		for (int i = loc; i < vec.length; i++) {
			vec2[pos] = vec[i];
			switch (evaluate(vec2, sum)) {
			case 0:
				print(vec2);
				break;
			case 1:
				printSum(vec, vec2, sum, loc + 1, pos + 1);
				break;
			default:
				break;
			}
			vec2[pos] = null;
		}
	}

}
