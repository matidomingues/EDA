package Ejercicio3;

public class Prom {

	private int num = 0;
	private int sum = 0;
	private int max = 0;
	private int min = 0;

	public void add(int num) {
		this.num += num;
		if (num > max) {
			this.max = num;
		}
		if (num < min) {
			this.min = num;
		}
		sum++;
	}

	public double evaluate() {
		if (sum == 0) {
			return 0;
		}
		return num / sum;
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
