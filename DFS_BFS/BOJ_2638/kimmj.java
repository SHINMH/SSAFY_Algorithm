package DFS_BFS.BOJ_2638;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kimmj {
	
	static int N, M, count, time;
	static int[][] cheese;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		cheese= new int[N][M];
		for (int n=0; n<N; n++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int m=0; m<M; m++) {
				cheese[n][m]= Integer.parseInt(st.nextToken());
				if (cheese[n][m]==1)
					count++;
			}
		}
		
		time= 0;
		bfs();
		
		bw.write(String.valueOf(time));
		br.close();
		bw.close();
		
	}
	
	private static void bfs() {
		
		Queue<Pos> queue= new LinkedList<>();
		
		int[] dr= {1, -1, 0, 0};
		int[] dc= {0, 0, -1, 1};
		
		while(true) {
			
			boolean[][] visited= new boolean[N][M];
			queue.offer(new Pos(0,0));
			visited[0][0]= true;
						
			while(!queue.isEmpty()) {
							
				int r= queue.peek().r;
				int c= queue.poll().c;
				
				for (int i=0; i<dr.length; i++) {
								
					int nr= r+dr[i];
					int nc= c+dc[i];
								
					if (nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
						if (cheese[nr][nc]==0) {
							visited[nr][nc]= true;
							queue.offer(new Pos(nr,nc));
						}
						if (cheese[nr][nc]>0)
							cheese[nr][nc]++;
					}
								
				}

			}
			
			for (int n=0; n<N; n++) {
				for (int m=0; m<M; m++) {
					if (cheese[n][m]>1) {
						if (cheese[n][m]<3) {
							cheese[n][m]= 1;
						}	
						else {
							cheese[n][m]= 0;
							count--;
						}
					}
				}
			}
			
			time++;			
			if (count==0)
				break;
			
		}
		
	}
	
	private static class Pos {
		
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
}
