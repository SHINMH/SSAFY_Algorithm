package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1987 {
	private static int N, M, max = 0;
	private final static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	private static char[][] str;
	private static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		str = new char[N][];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			str[i] = temp.toCharArray();
		}
		DFS(0, 0, 1 << (str[0][0] - 'A'), 1);

		bw.write(String.valueOf(max));
		bw.close();
	}

	private static void DFS(int row, int col, int visited, int cnt) {
		if(visit[row][col] == visited) return;
        visit[row][col] = visited;
		max = Math.max(max, cnt);
		for (int i = 0; i < 4; i++) {
			int nextx = col + dx[i];
			int nexty = row + dy[i];
			if (nexty >= N || nexty < 0 || nextx >= M || nextx < 0) continue;
			if ((visited & (1 << (str[nexty][nextx] - 'A'))) == 0) 
				DFS(nexty, nextx, visited | (1 << (str[nexty][nextx] - 'A')), cnt + 1);
		}
	}
}
