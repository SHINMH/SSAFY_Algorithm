package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2580 {
	private static int[][] Sudoku = new int[9][9];
	private static ArrayList<int[]> blank = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				Sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (Sudoku[i][j] == 0)
					blank.add(new int[] { i, j });
			}
		}
		while (blank.size() > 0) {
			for (int i = blank.size() - 1; i >= 0; i--) {
					if(checkRow(i)) continue;
					if(checkCol(i)) continue;
					if(checkSquare(i)) continue;
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				bw.write(Sudoku[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}

	private static boolean checkRow(int idx) {
		int[] pos = blank.get(idx);
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (int i = 0; i < 9; i++) {
			if (Sudoku[i][pos[1]] != 0)
				nums.remove((Integer) Sudoku[i][pos[1]]);
		}
		if (nums.size() == 1) {
			Sudoku[pos[0]][pos[1]] = nums.get(0);
			blank.remove(idx);
			return true;
		}
		return false;
	}

	private static boolean checkCol(int idx) {
		int[] pos = blank.get(idx);
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (int i = 0; i < 9; i++) {
			if (Sudoku[pos[0]][i] != 0)
				nums.remove((Integer) Sudoku[pos[0]][i]);
		}
		if (nums.size() == 1) {
			Sudoku[pos[0]][pos[1]] = nums.get(0);
			blank.remove(idx);
			return true;
		}
		return false;
	}

	private static boolean checkSquare(int idx) {
		int[] pos = blank.get(idx);
		int row = pos[0] / 3 * 3;
		int col = pos[1] / 3 * 3;
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (Sudoku[i][j] != 0)
					nums.remove((Integer) Sudoku[i][j]);
			}
		}
		if (nums.size() == 1) {
			Sudoku[pos[0]][pos[1]] = nums.get(0);
			blank.remove(idx);
			return true;
		}
		return false;
	}
}
