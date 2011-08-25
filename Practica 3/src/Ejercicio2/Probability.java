package Ejercicio2;

public class Probability {
	
	private int sum=0;
	private int num=0;
	
	public void add(int sum){
		this.sum += sum;
		num++;
	}
	
	public int evaluate(){
		if(num == 0){
			return 0;
		}
		return sum/num;
	}
	
	public int num(){
		return num;
	}
}
