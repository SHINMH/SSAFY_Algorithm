package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502 {
	private static int max = 0, zeroCnt = -3;
	private static ArrayList<int[]> virus;
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		char[][] map = new char[N][M];
		virus = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = input[c].charAt(0);
				if (map[r][c] == '0')
					zeroCnt++;
				if (map[r][c] == '2')
					virus.add(new int[] { r, c });
			}
		}
		createWall(map, 0, N, M, 0, 0);
		System.out.println(max);
	}

	private static void createWall(char[][] map, int cnt, int N, int M, int r, int c) {
		if (cnt == 3) {
			visited = new boolean[N][M];
			int zero = zeroCnt;
			for (int[] v : virus)
				zero -= bfs(map, N, M, v[0], v[1]);
			max = Math.max(max, zero);
			return;
		}
		if (r >= N)
			return;
		while (true) {
			if (c == M) {
				c = 0;
				r++;
			}
			if (r == N)
				break;
			if (map[r][c] != '0') {
				c++;
				continue;
	}
			map[r][c] = '1';
			createWall(map, cnt + 1, N, M, r, c + 1);
			map[r][c] = '0';
			c++;
		}
	}

	private static int bfs(char[][] map, int N, int M, int r, int c) {
		int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		int cnt = -1;
		while (!q.isEmpty()) {
			r = q.peek()[0];
			c = q.poll()[1];
			
			cnt++;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= N || nc >= M || nr < 0 || nc < 0 || visited[nr][nc])
					continue;
				if (map[nr][nc] == '0') {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
		return cnt;
	}
}
