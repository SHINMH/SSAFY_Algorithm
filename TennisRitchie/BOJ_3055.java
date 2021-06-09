package leejh;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {
	private static int r, c;
	private static Index FINISH;
	private static char[][] map;
	private static boolean[][] biberVisit, waterVisit;
	private static Queue<Index> waters, bibers;
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		biberVisit = new boolean[r][c];
		waterVisit = new boolean[r][c];
		waters = new LinkedList<>();
		bibers = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				map[i][j] = temp[j];
				if (temp[j] == 'D')
					FINISH = new Index(i, j);
				if (temp[j] == '*') {
					waters.add(new Index(i, j));
					waterVisit[i][j] = true;
				}
				if (temp[j] == 'S') {
					bibers.add(new Index(i, j));
					biberVisit[i][j] = true;
				}
			}
		}
		int answer = BFS();
		System.out.println((answer == 0) ? "KAKTUS" : answer);
	}
	private static int BFS() {
		int count = 0;
		while (!bibers.isEmpty()) {
			waterMove();
			count++;
			int len = bibers.size();
			for (int t = 0; t < len; t++) {
				Index biber = bibers.poll();
				for (int i = 0; i < 4; i++) {
					int nx = biber.x + dx[i];
					int ny = biber.y + dy[i];
					if (isVaild(nx, ny)) {
						if (nx == FINISH.x && ny == FINISH.y)
							return count;
						if (map[nx][ny] == '.' && !biberVisit[nx][ny]) {
							biberVisit[nx][ny] = true;
							map[nx][ny] = 'S';
							bibers.add(new Index(nx, ny));
						}
					}
				}
			}
		}
		return 0;
	}
	private static void waterMove() {
		int len = waters.size();
		for (int t = 0; t < len; t++) {
			Index water = waters.poll();
			for (int i = 0; i < 4; i++) {
				int nx = water.x + dx[i];
				int ny = water.y + dy[i];
				if (isVaild(nx, ny)) { // map 안에 있는지
					if (map[nx][ny] != 'X' && map[nx][ny] != 'D' && !waterVisit[nx][ny]) {
						map[nx][ny] = '*';
						waters.add(new Index(nx, ny));
						waterVisit[nx][ny] = true;
					}
				}
			}
		}
		return;
	}
	private static boolean isVaild(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;
	}
	static class Index {
		int x;
		int y;
		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
