package Ejercicio7;

public class Permutation {

	public void permutations(String s) {
		permutations(0, s.toCharArray());

	}

	private void permutations(int n, char[] string) {
		if (n == string.length) {
			System.out.println(string);
			return;
		}
		for (int i = n; i < string.length; i++) {
			swap(string, i, n);
			if (string[i] != string[n] || i == n) {
				permutations(n + 1, string);
			}
			swap(string, i, n);
		}
	}

	private void swap(char[] string, int index1, int index2) {
		char a;
		a = string[index1];
		string[index1] = string[index2];
		string[index2] = a;
	}
}
