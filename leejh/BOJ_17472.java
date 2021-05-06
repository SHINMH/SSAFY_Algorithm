package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BOJ_17472 {
	private static boolean[][] visited;
	private static int[] parents;

	private static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int dist;

		private Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j].charAt(0) - '0';
			}
		}
		int areaNum = 0;
		ArrayList<int[]> startPos = new ArrayList<>();
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					startPos.add(new int[] { i, j });
					areaMarking(map, N, M, i, j, ++areaNum);
				}
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[N][M];
		for (int i = 0; i < areaNum; i++) {
			int[] pos = startPos.get(i);
			getEdge(pq, map, N, M, pos[0], pos[1], i + 1);
		}
		kruscal(pq, areaNum);
	}

	private static void areaMarking(int[][] map, int N, int M, int r, int c, int areaNum) {
		visited[r][c] = true;
		map[r][c] = areaNum;
		int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= N || nc >= M || nr < 0 || nc < 0 || visited[nr][nc])
				continue;
			if (map[nr][nc] == 1) {
				areaMarking(map, N, M, nr, nc, areaNum);
			}
		}
	}

	private static void getEdge(PriorityQueue<Edge> pq, int[][] map, int N, int M, int r, int c, int curr) {
		visited[r][c] = true;
		for (int i = r + 1; i < N; i++) { // 아래
			if (map[i][c] == 0)
				continue;
			if (map[i][c] <= curr)
				break;
			int dist = i - r - 1;
			if (dist > 1)
				pq.offer(new Edge(curr, map[i][c], dist));
			break;

		}
		for (int i = r - 1; i >= 0; i--) { // 위
			if (map[i][c] == 0)
				continue;
			if (map[i][c] <= curr)
				break;
			int dist = r - i - 1;
			if (dist > 1)
				pq.offer(new Edge(curr, map[i][c], dist));
			break;
		}
		for (int i = c + 1; i < M; i++) { // 오른쪽
			if (map[r][i] == 0)
				continue;
			if (map[r][i] <= curr)
				break;
			int dist = i - c - 1;
			if (dist > 1)
				pq.offer(new Edge(curr, map[r][i], dist));
			break;
		}
		for (int i = c - 1; i >= 0; i--) { // 왼쪽
			if (map[r][i] == 0)
				continue;
			if (map[r][i] <= curr)
				break;
			int dist = c - i - 1;
			if (dist > 1)
				pq.offer(new Edge(curr, map[r][i], dist));
			break;
		}
		int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= N || nc >= M || nr < 0 || nc < 0 || visited[nr][nc])
				continue;
			if (map[nr][nc] == curr)
				getEdge(pq, map, N, M, nr, nc, curr);
		}
	}

	private static void kruscal(PriorityQueue<Edge> pq, int areaNum) {
		parents = new int[areaNum + 1];
		int res = 0;
		int cnt = 0;
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		int size = pq.size();
		for (int i = 0; i < size; i++) {
			Edge edge = pq.poll();

			int a = find(edge.from);
			int b = find(edge.to);

			if (a == b)
				continue;

			union(edge.from, edge.to);
			res += edge.dist;
			cnt++;
		}
		if (res == 0 || cnt != areaNum - 1) {
			System.out.println(-1);
		} else {
			System.out.println(res);

		}
	}

	public static int find(int a) {
		if (a == parents[a])
			return a;
		parents[a] = find(parents[a]);
		return parents[a];
	}

	public static void union(int s, int e) {
		int aRoot = find(s);
		int bRoot = find(e);

		if (aRoot != bRoot) {
			parents[aRoot] = e;
		} else {
			return;
		}
	}
}