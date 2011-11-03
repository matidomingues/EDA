package Ejercicio6;

public class Main {


	public static void main(String[] args) {
		Integer[][] test = new Integer[10][10];
		for(int i = 0; i<4; i++){
			for(int w = 0; w<4; w++){
				test[i][w] = (int)(Math.random()*10);
				System.out.print(test[i][w]);
			}
			System.out.println();
		}
		
		InvitedHillClimbing inv = new InvitedHillClimbing(4,test);
		Integer[] vec = new Integer[4];
		for(int i = 0; i<vec.length;i++){
			vec[i] = i;
		}
		inv.hillClimbing(vec);
		
	}

}
