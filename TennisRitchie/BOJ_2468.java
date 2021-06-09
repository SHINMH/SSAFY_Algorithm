package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;

public class BOJ_2468 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		BitSet bitset = new BitSet();
		String[] input;
		int max_h = 0, min_h = 100, cnt, ans = 1;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				max_h = Math.max(max_h, map[i][j]); // 높이 최댓값
				min_h = Math.min(min_h, map[i][j]); // 높이 최솟값
				bitset.set(map[i][j]); // 높이 값 1로 set

			}
		}
		for (int h = min_h; h < max_h; h++) { // 높이의 최솟값부터 높이의 최댓값 이전까지 반복
			if (!bitset.get(h)) // 현재 높이와 일치하는 높이의 건물이 없으면 어떤 이벤트도 발생하지않아 이전  구역 수와 동일하므로 건너뜀
				continue;
			boolean[][] visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > h && !visited[i][j]) {
						cnt++; // 구역 수 증가
						dfs(map, visited, N, h, i, j); //구간 탐색
					}
				}
			}
			ans = Math.max(cnt, ans); // 구간 최댓값 비교
		}
		bw.write(String.valueOf(ans));
		bw.close();
	}

	private static void dfs(int[][] map, boolean[][] visited, int N, int h, int row, int col) {
		visited[row][col] = true; // 현재 위치 방문
		int[] dx = new int[] { 1, 0, -1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		for (int d = 0; d < 4; d++) { // 다음 이동 위치
			int nexty = row + dy[d];
			int nextx = col + dx[d];
			if (nexty < 0 || nextx < 0 || nexty >= N || nextx >= N)
				continue;
			if (!visited[nexty][nextx] && map[nexty][nextx] > h) {
				dfs(map, visited, N, h, nexty, nextx);
			}
		}
	}
}
