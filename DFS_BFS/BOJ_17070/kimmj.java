package DFS_BFS.BOJ_17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class kimmj {
	
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N= Integer.parseInt(br.readLine());
		boolean[][] house= new boolean[N][N];
		
		int[] dr= {0,1,1};		// 오른쪽,오른쪽대각선,아래
		int[] dc= {1,1,0};
		
		for (int n=0; n<N; n++) {
			st= new StringTokenizer(br.readLine(), " ");
			for (int m=0; m<N; m++) {
				if (Integer.parseInt(st.nextToken())==1)
					house[n][m]= true;
			}
		}
		
		pipe(0, 1, 1, N, house, dr, dc);
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
		
	}
	
	private static void pipe(int r, int c, int mode, int N, boolean[][] house, int[] dr, int[] dc) {
		
		if (r==N-1 && c==N-1) {
			answer++;
			return;
		}
		
		switch(mode) {
			case 1:		// 가로
				if (r+dr[0]<N && c+dc[0]<N && !house[r+dr[0]][c+dc[0]]) {
					pipe(r+dr[0], c+dc[0], 1, N, house, dr, dc);
					if (r+dr[0]<N && c+dc[0]<N && r+dr[1]<N && c+dc[1]<N && r+dr[2]<N && c+dc[2]<N
							&& !house[r+dr[0]][c+dc[0]] && !house[r+dr[1]][c+dc[1]] && !house[r+dr[2]][c+dc[2]]) {
						pipe(r+dr[1], c+dc[1], 3, N, house, dr, dc);
					}
				}
				break;
			case 2:		// 세로
				if (r+dr[2]<N && c+dc[2]<N && !house[r+dr[2]][c+dc[2]]) {
					pipe(r+dr[2], c+dc[2], 2, N, house, dr, dc);
					if (r+dr[0]<N && c+dc[0]<N && r+dr[1]<N && c+dc[1]<N && r+dr[2]<N && c+dc[2]<N
							&& !house[r+dr[0]][c+dc[0]] && !house[r+dr[1]][c+dc[1]] && !house[r+dr[2]][c+dc[2]]) {
						pipe(r+dr[1], c+dc[1], 3, N, house, dr, dc);
					}
				}				
				break;
			case 3:		// 대각선
				if (r+dr[0]<N && c+dc[0]<N && !house[r+dr[0]][c+dc[0]]) {
					pipe(r+dr[0], c+dc[0], 1, N, house, dr, dc);
				}
				if (r+dr[2]<N && c+dc[2]<N && !house[r+dr[2]][c+dc[2]]) {
					pipe(r+dr[2], c+dc[2], 2, N, house, dr, dc);
				}
				if (r+dr[0]<N && c+dc[0]<N && r+dr[1]<N && c+dc[1]<N && r+dr[2]<N && c+dc[2]<N
						&& !house[r+dr[0]][c+dc[0]] && !house[r+dr[1]][c+dc[1]] && !house[r+dr[2]][c+dc[2]]) {
					pipe(r+dr[1], c+dc[1], 3, N, house, dr, dc);
				}
				break;
		}
		
		
	}
	
}
