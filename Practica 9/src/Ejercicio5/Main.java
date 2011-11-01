package Ejercicio5;

public class Main {


	public static void main(String[] args) {
		Integer[][] test = new Integer[10][10];
		for(int i = 0; i<8; i++){
			for(int w = 0; w<8; w++){
				test[i][w] = (int)(Math.random()*10);
				System.out.print(test[i][w]);
			}
			System.out.println();
		}
		
		Invited data = new Invited(8, test);
		data.arrangeTables(8);
		

	}

}
