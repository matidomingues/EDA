package Ejercicio8;

public class Matrix {
	public static void main(String[] args){
		Integer[][] a = {{0,0,1,1,0,0},{0,1,0,0,1,0},{1,0,0,0,0,1},{1,0,0,0,0,1},{0,1,0,0,1,0},{0,0,1,1,0,0}};
		BooleanPainter test = new BooleanPainter();
		
		test.paint(a, 2,2, 1);
		for(Integer[] b: a){
			System.out.println("");
			for(Integer c: b){
				System.out.print(c);
			}
		}
				
		}
}
