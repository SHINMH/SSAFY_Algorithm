package leejh;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2239_스도쿠 {
	private static int[][] sudoku = new int[9][9];
	private static int[] rows = new int[9], cols = new int[9], blocks = new int[9];
	private static ArrayList<Point> zeroes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
	}
	private static void dfs(int index) throws IOException {
		if (index == zeroes.size()) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int[] row : sudoku) {
				for (int col : row)
					bw.write(String.valueOf(col));
				bw.write("\n");
			}
			bw.close();
			System.exit(0);
		}
		Point cur = zeroes.get(index);
		for (int i = 1; i < 10; i++) {
			if ((rows[cur.y] & (1 << i)) == 0)
				if ((cols[cur.x] & (1 << i)) == 0)
					if ((blocks[(cur.y / 3) * 3 + cur.x / 3] & (1 << i)) == 0) {
						sudoku[cur.y][cur.x] = i;
						rows[cur.y] |= (1 << i);
						cols[cur.x] |= (1 << i);
						blocks[(cur.y / 3) * 3 + cur.x / 3] |= (1 << i);
						dfs(index + 1);
						rows[cur.y] &= ~(1 << i);
						cols[cur.x] &= ~(1 << i);
						blocks[(cur.y / 3) * 3 + cur.x / 3] &= ~(1 << i);
					}
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		for (int i = 0; i < 9; i++) {
			input = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = input.charAt(j)-'0';
				if (sudoku[i][j] == 0)
					zeroes.add(new Point(j, i));
				else {
					rows[i] |= (1 << sudoku[i][j]);
					cols[j] |= (1 << sudoku[i][j]);
					blocks[(i / 3) * 3 + j / 3] |= (1 << sudoku[i][j]);
				}
			}
		}
	}
}
