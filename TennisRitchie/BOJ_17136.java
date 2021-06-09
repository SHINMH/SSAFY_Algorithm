package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17136 {
	private static boolean[][] map = new boolean[10][10];
	private static int[] paperCnt = { 0, 0, 0, 0, 0 };
	private static int ans = 25;

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[];
		for (int i = 0; i < 10; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < 10; j++)
				map[i][j] = (input[j].charAt(0) == '1') ? true : false;
		}
		dfs(0, 0, 0);
		System.out.println((ans == 25) ? "-1" : String.valueOf(ans));
	}

	private static void dfs(int r, int c, int cnt) {
		if (r >= 10) {
			ans = Math.min(ans, cnt);
			return;
		}
		if (c >= 10) {
			dfs(r + 1, 0, cnt);
			return;
		}
		if (map[r][c]) {
			for (int k = 0; k < 5; k++) {
				if (paperCnt[k] == 5)
					continue;
				if (c + k >= 10 || r + k >= 10)
					continue;
				boolean flag = false;
				for (int i = r; i < r + k + 1; i++) {
					for (int j = c; j < c + k + 1; j++) {
						if (!map[i][j]) {
							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}
				if (!flag) {
					for (int i = r; i < r + k + 1; i++)
						for (int j = c; j < c + k + 1; j++)
							map[i][j] = false;

					paperCnt[k]++;
					dfs(r, c + k + 1, cnt + 1);
					paperCnt[k]--;

					for (int i = r; i < r + k + 1; i++)
						for (int j = c; j < c + k + 1; j++)
							map[i][j] = true;
				}
			}
		} else {
			dfs(r, c + 1, cnt);
		}
	}
}
