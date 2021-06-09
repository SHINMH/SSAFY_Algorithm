package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ_2234 {
	private static int cnt = 0, area = 0, max = 0;
	private static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 }, wall = { 1, 2, 4, 8 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(input[j]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					cnt = 0; // 같은 구역의 길이
					dfs(map, visited, N, M, i, j);
					max = Math.max(cnt, max); // 최대 구역의 길이
					arr.add(new int[] { area, cnt, i, j });
					area++;
				}
			}
		}
		bw.write(area + "\n" + max);
		max = 0;
		for (int i = 0; i < arr.size(); i++) {
			int[] temp = arr.get(i);
			visited = new boolean[N][M];
			check(arr, map, visited, N, M, temp[2], temp[3], temp[0]);
		}
		bw.write("\n" + max);
		bw.close();
	}

	private static void dfs(int[][] map, boolean[][] visited, int N, int M, int r, int c) {
		visited[r][c] = true;
		map[r][c] = area;
		cnt++;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || (map[nr][nc] & wall[d]) > 0)
				continue;
			dfs(map, visited, N, M, nr, nc);
		}
	}

	private static void check(ArrayList<int[]> arr, int[][] map, boolean[][] visited, int N, int M, int r, int c,
			int cur) {
		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
				continue;
			if (map[nr][nc] == cur)
				check(arr, map, visited, N, M, nr, nc, cur);
			else
				max = Math.max(max, arr.get(cur)[1] + arr.get(map[nr][nc])[1]);
		}
	}
}
