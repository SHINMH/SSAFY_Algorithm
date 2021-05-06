package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class AreaPos {
	ArrayList<int[]> pos;
	int sum;

	public AreaPos() {
		pos = new ArrayList<>();
		sum = 0;
	}
}

public class BOJ_16234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int L = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(input[j]);
		}
		boolean[][] visited;
		int cnt;
		int ans = 0;
		while (true) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(map, N, L, R, visited, i, j);
						cnt++;
					}
				}
			}
			if (cnt == N*N) break;
			ans++;
		}
		System.out.println(ans);
	}

	private static void bfs(int[][] map, int N, int L, int R, boolean[][] visited, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		AreaPos Area = new AreaPos();
		int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
		visited[r][c] = true;
		q.offer(new int[] { r, c });
		while (!q.isEmpty()) {
			r = q.peek()[0];
			c = q.poll()[1];
			Area.pos.add(new int[] { r, c });
			Area.sum += map[r][c];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= N || nc >= N || nc < 0 || nr < 0 || visited[nr][nc]) continue;
				int dif = Math.abs(map[r][c] - map[nr][nc]);
				if (dif >= L && dif <= R) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		move(map, Area);
	}

	private static void move(int[][] map, AreaPos Area) {
		if(Area.pos.size() == 1) return;
		int newPop = Area.sum / Area.pos.size();
		for (int[] pos : Area.pos)
			map[pos[0]][pos[1]] = newPop;
	}
}