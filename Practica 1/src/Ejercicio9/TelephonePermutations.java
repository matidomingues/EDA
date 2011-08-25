package Ejercicio9;

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

	public void permutations(String num) {
		StringBuffer a = new StringBuffer();
		//permute(num, 0, "");
		permute(num.toCharArray(),0,0,a);
	}

	private void permute(char[] number, Integer n, Integer index, StringBuffer last) {
		
		if (index == number.length) {
			System.out.println(last);
			return;
		}
		int b = number[index]-48;
		last.append(refer.get(b).charAt(n));
		permute(number, n, index + 1, last);
		last.deleteCharAt(index);
		System.out.println((refer.get(b)).length());
		for(n=0; n<((refer.get(b)).length());n++){
			permute(number, n + 1, index, last);
			last.deleteCharAt(n);
		}
		return;
	}
	
	
	
	
	
	@SuppressWarnings("unused")
	private void permute(String number, Integer index, String last) {
		if (index == number.length()) {
			System.out.println(last);
			return;
		}
		int b = number.charAt(index)-48;
		for(int n=0; n<((refer.get(b)).length());n++){
			permute(number, index+1, last+refer.get(b).charAt(n));
		}
	}
}
