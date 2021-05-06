package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3109 {
	private static int N, M, ans = 0;
	private static int[] dy = { -1, 0, 1 };
	private static boolean[][] visited;
	private static String[] map;
	private static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		map = new String[N];
		for (int i = 0; i < N; i++) map[i] = br.readLine();
		for (int i = 0; i < N; i++) {
			flag = false;
			DFS(i, 0);
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}

	private static void DFS(int row, int col) {
		if (col == M - 1) {
			flag=true;
			ans++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nextR = row + dy[i];
			int nextC = col + 1;
			if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0) continue;
			if (map[nextR].charAt(nextC) == '.') {
				if (!visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					DFS(nextR, nextC);
					if(flag) return;
				}
			}
		}
	}
}
