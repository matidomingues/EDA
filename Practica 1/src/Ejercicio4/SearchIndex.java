package Ejercicio4;

public class SearchIndex {

	/**
	 * Complexity: O(log(N)).
	 * 
	 * @param array
	 * @return
	 */
	public boolean binaryIndex(Integer array[]) {
		int start = (array.length - 1) / 2, end = array.length - 1;
		int wall = 0;
		while (true) {
			if (array[start] == start) {
				return true;
			} else if (start == end) {
				break;
			} else if (array[start] < start) {
				wall = start;
				System.out.println((int) (start + Math
						.floor(((double) (end - start) / 2) + 0.5f)));
				start = (int) (start + Math
						.floor((((double) (end - start) / 2)) + 0.5f));
			} else if (array[start] > start) {
				end = start;
				start = start
						- (int) Math
								.floor(((double) (start - wall) / 2) + 0.5f);
			}
		}
		return false;
	}
}
