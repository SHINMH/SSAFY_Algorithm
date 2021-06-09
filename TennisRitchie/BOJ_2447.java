package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2447 {
	private static boolean[][] map;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		draw(0, 0, N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				bw.write(map[i][j] ? " " : "*");
			bw.write("\n");
		}
		bw.close();
	}
	private static void draw(int row, int col, int N) {
		if (N == 1) return;
		for (int i = row + N / 3; i < row + N / 3 * 2; i++) // 가운데 영역 true(공백)로 셋팅
			for (int j = col + N / 3; j < col + N / 3 * 2; j++)
				map[i][j] = true;
		for (int i = 0; i < 3; i++) // 가운데를 제외한 영역 draw 메써드 재호출
			for (int j = 0; j < 3; j++)
				draw(row + N / 3 * i, col + N / 3 * j, N / 3);
	}
}
