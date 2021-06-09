package BOJ_2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	static List<int[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		list = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		searchIce();
	}
	
	static void searchIce() {
		int day = 0;
		int count;
		while(true) {
			count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && map[i][j] > 0) {
						count++;
						dfs(i, j);
					}
				}
			}
			melt();
			
			if(count >= 2) {
				System.out.println(day);
				break;
			}else if (count == 0) {
				System.out.println(0);
				break;
			}
			day++;
		}
	}
	
	static void melt() {
		while (!list.isEmpty()) {
			int[] ice = list.remove(0);
			map[ice[0]][ice[1]] = Math.max(0, map[ice[0]][ice[1]] - ice[2]);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		int ny, nx;
		int count = 0;
		for(int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];
			if(ny >= 0 && ny < N && nx >= 0 && nx < M) {
				if(map[ny][nx] == 0) {
					count++;
				}else if(map[ny][nx] > 0 && !visited[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
		list.add(new int[] {y, x, count});
	}
}
