package Ejercicio5;

public class Main {


	public static void main(String[] args) {
		Integer[][] test = new Integer[10][10];
		for(int i = 0; i<10; i++){
			for(int w = 0; w<10; w++){
				test[i][w] = (int)(Math.random()*10);
				System.out.print(test[i][w]);
			}
			System.out.println();
		}
		
		Invited data = new Invited(10, test);
	//	data.arrangeTables(8);
		Integer[] test2 = new Integer[test.length];
		for(int i = 0; i<test2.length; i++){
			test2[i] = i;
		}
		
		data.disorder2(test2);

	}

}
