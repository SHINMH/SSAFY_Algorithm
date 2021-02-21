package SSAFY_Algorithm.DFS_BFS.BOJ_7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class shinmh {
	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int count = M * N;
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		int[][] map = new int[N][M];
		int day = -1;
		Queue<Position> queue = new LinkedList<Position>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) count--;
				else if(map[i][j] == 1) queue.add(new Position(j,i));
			}
		}
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				Position position = queue.poll();
				count--;
				
				for(int i = 0; i < 4; i++) {
					int nx = position.x + dx[i];
					int ny = position.y + dy[i];
					
					if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
						if(map[ny][nx] == 0) {
							queue.add(new Position(nx,ny));
							map[ny][nx] = 1;
						}
					}
				}
				
				size--;
			}
			day++;
		}
		
		System.out.println(count > 0 ? -1 : day);
	}
}
