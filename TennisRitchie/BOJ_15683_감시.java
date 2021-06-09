package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_15683_감시 {
	private static class Cam{
		private int x,y,no,left,right,up,down;
		public Cam(int x, int y, int no, int left, int right, int up, int down) {
			super();
			this.x = x;
			this.y = y;
			this.no = no;
			this.left = left;
			this.right = right;
			this.up = up;
			this.down = down;
		}
	}
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String[] input = br.readLine().split(" ");
	int N = Integer.parseInt(input[0]);
	int M = Integer.parseInt(input[1]);
	char[][] map = new char[N][M];
	boolean[][] visited = new boolean[N][M];
	int cntzero=0;
	ArrayList<Cam> camera = new ArrayList<>();
	for(int r = 0; r < N; r++) {
		input = br.readLine().split(" ");
		for(int c = 0; c < M;c++) {
			map[r][c] = input[0].charAt(0);
			if(map[r][c] == '0')
				cntzero++;
			else if(map[r][c] == '6')
				visited[r][c] = true;
			else 
				camera.add(new Cam(r,c,map[r][c],-1,N,-1,M));
		}
	}
}
}
