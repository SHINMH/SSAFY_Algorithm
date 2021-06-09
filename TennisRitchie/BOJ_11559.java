package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_11559 {
	private static boolean eventFlag;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];
		int[] start = new int[6];
		for (int i = 0; i < 12; i++) {
			String input = br.readLine();
			for (int j = 0; j < 6; j++) {
				char val = input.charAt(j);
				if (val == '.')
					continue;
				map[start[j]++][j] = val;
			}
		}
		for(int j = 0; j<6;j++) start[j] = 12 - start[j];
		int ans = 0;
		while (true) {
			gravity(map, start);
			eventFlag = false;
			visited = new boolean[12][6];
			
			for (int j = 0; j < 6; j++) 
				for (int i = start[j]; i < 12; i++) 
					if (!visited[i][j]) bfs(map, start, i, j);
			
			if (!eventFlag) break;
			ans++;
		}
		System.out.println(ans);
	}

	private static void bfs(char[][] map, int[] start, int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		Stack<int[]> stack = new Stack<>();
		int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
		visited[r][c] = true;
		q.offer(new int[] { r, c });
		int cnt = 0;
		while (!q.isEmpty()) {
			r = q.peek()[0];
			c = q.poll()[1];
			stack.push(new int[] {r,c});
			cnt++;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr >= 12 || nc >= 6 || nc < 0 || nr < 0 || visited[nr][nc])
					continue;
				if (map[nr][nc] == map[r][c]) {
					visited[nr][nc] = true;
					q.offer(new int[] { nr, nc });
				}
			}
		}
		if (cnt >= 4) {
			eventFlag = true;
			while(!stack.empty())
				map[stack.peek()[0]][stack.pop()[1]]='\0';
		}
	}

	private static void gravity(char[][] map, int[] start) {
		for (int j = 0; j < 6; j++) {
			boolean isInPuyo = false;
			for (int i = 11; i > 0; i--) {
				if (map[i][j] != '\0') {
					isInPuyo = true;
					continue;
				}
				boolean flag = false;
				int idx = i - 1;
				while (idx >= 0) {
					if (map[idx][j] != '\0') {
						flag = true;
						isInPuyo = true;
						map[i][j] = map[idx][j];
						map[idx][j] = '\0';
						start[j] = i;
						break;
					}
					idx--;
				}
				if (!flag) break;
			}
			if (!isInPuyo) start[j] = 12;
		}
	}
}
