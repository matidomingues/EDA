package Ejercicio6;

import java.util.HashMap;

public class TelephonePermutations {

	public HashMap<Integer, String> refer = new HashMap<Integer, String>();

	public TelephonePermutations() {
		refer.put(2, "ABC");
		refer.put(3, "DEF");
		refer.put(4, "GHI");
		refer.put(5, "JKL");
		refer.put(6, "MNO");
		refer.put(7, "PQRS");
		refer.put(8, "TUV");
		refer.put(9, "WXYZ");
	}

	public void permute(String number) {
		Stack<String> elems = new Stack<String>();
		String base;
		do {
			base = elems.pop();
			if (base == null) {
				base = "";
			}
			if (base.length() == number.length()) {
				System.out.println(base);
			} else {
				int b = number.charAt(base.length()) - 48;
				for (int z = 0; z < (refer.get(b)).length(); z++) {
					elems.push(base + ((refer.get(b)).charAt(z)));
				}
			}
		} while (!elems.isEmpty());

	}
}
