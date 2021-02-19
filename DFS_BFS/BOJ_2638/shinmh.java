package SSAFY_Algorithm.DFS_BFS.BOJ_2638;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class shinmh {
	static class Pos {
		int y;
		int x;
		
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countDay();

		System.out.println(answer);
	}
	
	static void countDay() {
		while(true) {
			dfs(0, 0);
			if(checkCheese() == 0) break;
			answer++;
		}
	}
	
	static int checkCheese() {
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == -1) {
					map[i][j] = 0;
				}else if(map[i][j] == 2){
					map[i][j] = 1;
				}else if(map[i][j] > 2) {
					map[i][j] = 0;
					count++;
				}
			}
		}
		return count;
	}
	
	static void dfs(int y, int x) {
		map[y][x] = -1;
			
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(inRange(ny,nx)) {
				if(map[ny][nx] == 0) {
					dfs(ny, nx);
				}else if(map[ny][nx] >= 1) {
					map[ny][nx]++;
				}
			}
		}
	}
	
	static boolean inRange(int y, int x) {
		if(y >= 0 && y < N && x >= 0 && x < M) {
			return true;
		}
		return false;
	}
}
