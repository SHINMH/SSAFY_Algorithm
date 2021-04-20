package DFS_BFS.BOJ_7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kimmj {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[] dx= {-1, 1, 0, 0};
		int[] dy= {0, 0, -1, 1};
		
		st= new StringTokenizer(br.readLine(), " ");
		int M= Integer.parseInt(st.nextToken());
		int N= Integer.parseInt(st.nextToken());
		
		int answer= 0;
		int[][] tomatoes= new int[N][M];
		boolean[][] visited= new boolean[N][M];
		Queue<Pos> queue= new LinkedList<>();
		boolean flag= true;
		
		for (int n=0; n<N; n++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int m=0; m<M; m++) {
				tomatoes[n][m]= Integer.parseInt(st.nextToken());
				if (tomatoes[n][m]==1) {
					queue.add(new Pos(n,m));
					visited[n][m]= true;
				} else if (tomatoes[n][m]==0) {
					flag= false;
				} else {
					visited[n][m]= true;
				}
			}
		}
		
		if(!flag) {
			while(!queue.isEmpty()) {
				
				int r= queue.peek().row;
				int c= queue.peek().col;
				queue.poll();
				
				for (int i=0; i<4; i++) {
					int nr= r+dx[i];
					int nc= c+dy[i];
					if (nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc]) {
						tomatoes[nr][nc]= tomatoes[r][c]+1;
						queue.add(new Pos(nr,nc));
						visited[nr][nc]= true;
					}
				}
			}
		}
		
		for (int n=0; n<N; n++) {
			for (int m=0; m<M; m++) {
				answer= Math.max(answer, tomatoes[n][m]-1);
				if (tomatoes[n][m]==0) {
					answer= -1;
					break;
				}
			}
			if (answer==-1)	break;
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}
	
	private static class Pos {
		int row;
		int col;
		
		public Pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
}
