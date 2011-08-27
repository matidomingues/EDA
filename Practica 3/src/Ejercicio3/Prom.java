package Ejercicio3;

public class Prom {

	private int num = 0;
	private int sum = 0;
	private int max = 0;
	private int min = 0;

	public void add(int num) {
		this.num += num;
		if(max == 0 && min == 0){
			max = min = this.num;
		}else if (this.num > max) {
			this.max = this.num;
		}
		sum++;
	}

	public void addSpecial(int num){
		this.num -= num;
		if(this.num < min){
			min = this.num;
		}
		sum++;
	}
	public int getMax() {
		return max;
	}

	public int getMin() {
		return min;
	}

	public double evaluate() {
		if (sum == 0) {
			return 0;
		}
		return (double)num / sum;
	}

	public void sumProm(Prom data) {
		this.num += data.num;
		this.sum += data.sum;
		if (this.min > data.min) {
			this.min = data.min;
		}
		if (this.max < data.max) {
			this.max = data.max;
		}
	}
}
