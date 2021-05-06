package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17135 {
	static int N, M, D, ans = 0, archerPosOrigin, max, Enemy = 0;
	static int[] dy = { 0, -1, 0 }, dx = { -1, 0, 1 };
	static int[] selected = new int[3];
	static int[][] mapOrigin,map;
	static Queue<int[]> q, queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		mapOrigin = new int[N][M];
		archerPosOrigin = N;
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				mapOrigin[row][col] = Integer.parseInt(st.nextToken());
				if (mapOrigin[row][col] == 1)
					Enemy++;
			}
		}
		combination(0, 0);
		bw.write(String.valueOf(ans));
		bw.close();
	}

	private static void combination(int cnt, int start) {
		if (cnt == 3) {
			shoot();
			return;
		}
		for (int i = start; i < M; ++i) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

	private static void shoot() {
		map = new int[N][M];
		int aliveEnemy = Enemy;
		int killedEnemy = 0;
		int archerPos = archerPosOrigin;
		for (int row = 0; row < N; row++)
			for (int col = 0; col < M; col++) 
				map[row][col] = mapOrigin[row][col];
			
		while (archerPos > 0) {
			if (aliveEnemy<=0) {
				ans = Math.max(killedEnemy, ans);
				return;
				}
			q = new LinkedList<>();
			for (int i = 0; i < 3; i++) {
				queue = new LinkedList<>();
				queue.offer(new int[] { archerPos - 1, selected[i] });
				BFS(archerPos, selected[i]);
			}
			killedEnemy += q.size();
			aliveEnemy -= q.size();
			while(!q.isEmpty()) {
				int row = q.peek()[0];
				int col = q.poll()[1];
				map[row][col] = 0;
			}
			for (int i = 0; i < M; i++)
				if (map[archerPos-1][i] == 1)
					aliveEnemy--;
			archerPos--;
		}
		ans = Math.max(killedEnemy, ans);
	}

	private static void BFS(int curRow,int curCol) {
		while (!queue.isEmpty()) {
			boolean[][] visited = new boolean[N][M];
			int row = queue.peek()[0];
			int col = queue.poll()[1];
			if(Math.abs(curRow-row) + Math.abs(curCol - col) > D) return;
			if (map[row][col] == 1) {
				boolean f = false;
				for(int[] temp : q) {
					if(temp[0]==row && temp[1]==col) {
						f = true;
						break;
					}
				}
					if(!f) q.offer(new int[] { row, col });
				return;
			}
			for (int i = 0; i < 3; i++) {
				int nextRow = row + dy[i];
				int nextCol = col + dx[i];
				if (nextRow < 0 || nextCol < 0 || nextCol >= M) continue;
				if(!visited[nextRow][nextCol]) queue.offer(new int[]{nextRow, nextCol});
				visited[nextRow][nextCol] = true;
			}
		}
	}
}


/*for (int row = 0; row < N; row++) {
	
	for (int col = 0; col < M; col++) {
		map[row][col] = mapOrigin[row][col];
		System.out.print(map[row][col]+" ");
	}
	System.out.println();
}
System.out.println();*/
