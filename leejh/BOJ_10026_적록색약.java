package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {
	private static int N, isAns = 0, isNotAns = 0;
	private static int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
	private static boolean[][] visited, visited_RG;
	private static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visited = new boolean[N][N];
		visited_RG = new boolean[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					DFS(r, c);
					isAns++;
					isNotAns++;
					if (visited_RG[r][c])isNotAns--;
				}
				if (visited_RG[r][c]) {
					DFS_RG(r, c);
					isNotAns++;
			}
		}
		}
		System.out.println(isNotAns+" "+isAns);
	}

	private static void DFS(int r, int c) {
		visited[r][c] = true;
		if(map[r][c] == 'R' || map[r][c] == 'G')
			visited_RG[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;
			if (map[nr][nc] == map[r][c]
					|| ((map[r][c] == 'R' || map[r][c] == 'G') && (map[nr][nc] == 'R' || map[nr][nc] == 'G')))
				DFS(nr, nc);
		}
	}
	private static void DFS_RG(int r, int c) {
		visited_RG[r][c] = false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || !visited_RG[nr][nc])
				continue;
			if (map[nr][nc] == map[r][c])
				DFS_RG(nr, nc);
		}
	}
}
