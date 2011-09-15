package Ejercicio3;

public class isBalanced {
	/**
	 * 2:00 - 2:20
	 * 
	 * @param data
	 * @return
	 */
	public static boolean balanced(char[] data) {
		Stack stack = new Stack();
		for (int i = 0; i < data.length; i++) {
			int b = data[i];
			if (b - '0' < 0 || b - '0' > 9) {
				if (b == '}' || b == ']' || b == ')') {
					String a = stack.pop();
					if (a == null) {
						return false;
					} else if (!a.equals(String.valueOf(b))) {
						return false;
					}

				} else {
					stack.push(String.valueOf(b));
				}
			}
		}
		return true;
	}

	
}
