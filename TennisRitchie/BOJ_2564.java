package leejh;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2564 {
	static int G, S;
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		G = Integer.parseInt(st.nextToken());// 가로
		S = Integer.parseInt(st.nextToken());// 세로

		int map[][] = new int[S + 1][G + 1];
		boolean visited[][] = new boolean[S + 1][G + 1];
		for (int i = 0; i < S + 1; i++) {
			map[i][0] = 1;
			map[i][G] = 1;
		}
		for (int i = 0; i < G + 1; i++) {
			map[0][i] = 1;
			map[S][i] = 1;
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int direct = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			Point xy = makexy(direct, dist);
			map[xy.x][xy.y] = 2;
		}

		st = new StringTokenizer(br.readLine());
		Point me = makexy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		visited[me.x][me.y] = true;
		int result = 0;
		Queue<Point> que = new LinkedList<Point>();
		que.add(me);
		que.add(new Point(-1, -1));
		int dist = 1;
		int cnt = 0;
		gg: while (true) {
			Point now = que.poll();
			if (now.x == -1) {
				dist++;
				if (que.isEmpty())
					break;
				que.add(new Point(-1, -1));
			}

			for (int i = 0; i < 4; i++) {
				int row = now.x + dr[i];
				int col = now.y + dc[i];
				if (row < 0 || col < 0 || row >= S + 1 || col >= G + 1)
					continue;
				if (map[row][col] == 0)
					continue;
				if (visited[row][col])
					continue;

				visited[row][col] = true;
				if (map[row][col] == 2) {
					result += dist;
					if (++cnt == N)
						break gg;
				}
				que.offer(new Point(row, col));
			}
		}
		System.out.println(result);

	}

	static Point makexy(int direct, int dist) {
		if (direct == 1)
			return new Point(0, dist);

		else if (direct == 2)
			return new Point(S, dist);

		else if (direct == 3)
			return new Point(dist, 0);

		else if (direct == 4)
			return new Point(dist, G);
		return null;
	}

}