package Ejercicio2;

import java.util.LinkedList;
import java.util.List;

public class CaballoAjedrez {

	Integer board[][] = new Integer[8][8];
	List<Point> moves = new LinkedList<Point>();

	public Integer[][] clone(Integer[][] board){
		Integer[][] newBoard = new Integer[8][8];
		for (int i = 0; i < 8; i++) {
			for (int w = 0; w < 8; w++) {
				newBoard[i][w] = board[i][w];
			}
		}
		return newBoard;
	}
	
	public CaballoAjedrez() {
		for (int i = 0; i < 8; i++) {
			for (int w = 0; w < 8; w++) {
				board[i][w] = null;
			}
		}

		moves.add(new Point(2, 1));
		moves.add(new Point(2, -1));
		moves.add(new Point(-2, 1));
		moves.add(new Point(-2, -1));
		moves.add(new Point(1, 2));
		moves.add(new Point(-1, 2));
		moves.add(new Point(1, -2));
		moves.add(new Point(-1, -2));
	}

	public void getSolution() {

		for (int i = 0; i < 8; i++) {
			for (int w = 0; w < 8; w++) {
				Integer[][] newBoard = clone(board);
				newBoard[i][w] = 1;
				print(newBoard);
				if(calcMovements(newBoard, 2, new Point(i, w))){
					return;
				}
			}
		}
	}

	private List<Point> calcDirections(Point p, Integer[][] board) {
		List<Point> aux = new LinkedList<Point>();
		for (Point dir : moves) {
			Point point = p.sumPoint(dir);
			if (checkValid(point, board)) {
				aux.add(p.sumPoint(dir));
			}
		}
		return aux;
	}

	private boolean inBounds(Point p){
		if(p.x >= 0 && p.x <8 && p.y >=0 && p.y<8){
			return true;
		}
		return false;
	}
	
	
	private boolean checkValid(Point p, Integer[][] board) {
		if (inBounds(p) && board[p.x][p.y] == null) {
			return true;
		} else {
			return false;
		}
	}

	private void print(Integer[][] board){
		for(Integer[] a: board){
			for(Integer b: a){
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	private boolean calcMovements(Integer[][] board, int num, Point lastAdd) {
		if (num == 65) {
			print(board);
			return true;
		}
		boolean enter = false;
		for (Point p : calcDirections(lastAdd, board)) {
			enter = true;
			Integer[][] newBoard = clone(board);
			newBoard[p.x][p.y] = num;
			//print(newBoard);
			calcMovements(newBoard, num + 1, p);
		}
		if (enter) {
			return true;
		}
		return false;
	}

	private static class Point {
		Integer x;
		Integer y;

		public Point(Integer x, Integer y) {
			this.x = x;
			this.y = y;
		}

		public Point sumPoint(Point p) {
			return new Point(this.x + p.x, this.y + p.y);
		}
	}
}
