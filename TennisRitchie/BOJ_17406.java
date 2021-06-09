package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17406 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int m,n,k;
	static int[][] arr;
	static int[][] K;
	static int min = 9999999;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		K = new int[k][3];
		int[] visit = new int[k];
		int[] selected = new int[k];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			K[i][0] = Integer.parseInt(st.nextToken());
			K[i][1] = Integer.parseInt(st.nextToken());
			K[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < k; i++) 
			dfs(i, 0, visit, selected);
		
		bw.write(String.valueOf(min));
		bw.flush();
	}
	
	public static void dfs(int x, int toSelect, int[] visit, int[] selected) {
		visit[x] = 1;
		selected[toSelect] = x;
		if(toSelect == k - 1) {
			int[][] new_arr = new int[n][m];
			for(int i = 0; i < n; i++) 
				for(int j = 0; j < m; j++) 
					new_arr[i][j] = arr[i][j];
				
			for(int i = 0; i < k; i++) 
				rotate(K[selected[i]][0], K[selected[i]][1], K[selected[i]][2], new_arr);
			
			for(int i = 0; i < n; i++) {
				int sum = 0;
				for(int j = 0; j < m; j++) 
					sum += new_arr[i][j];
				
				min = Math.min(sum, min);
			}
		}
		for(int i = 0; i < k; i++) 
			if(visit[i] == 0) dfs(i, toSelect + 1, visit, selected);
		visit[x] = 0;
		selected[toSelect] = 0;
	}

	public static void rotate(int r, int c, int s, int[][] arr) {
		for(int i = 0; i < s; i++) {
			int r_min = r - s - 1 + i, r_max = r + s - 1 - i;
			int c_min = c - s - 1 + i, c_max = c + s - 1 - i;
			int x = r_min,y = c_min;
			int d = 0;
			int tmp = arr[x][y];
			while(true) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx > r_max || ny > c_max || nx < r_min || ny < c_min) {
					d++;
					if(d > 3) break;	
				}
				else{
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}
			}
			arr[x][y + 1] = tmp;
		}
	}
}
