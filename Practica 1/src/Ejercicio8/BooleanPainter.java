package Ejercicio8;

public class BooleanPainter {
	public void paint(Integer[][] a, int x, int y, int colour) {
		if (x < 0 || x > a.length || y < 0
				|| y > a.length || a[x][y] == colour) {
			return;
		} else {
			a[x][y] = colour;
		}
		paint(a, x + 1, y, colour);
		paint(a, x - 1, y, colour);
		paint(a, x, y + 1, colour);
		paint(a, x, y - 1, colour);
	}
}
