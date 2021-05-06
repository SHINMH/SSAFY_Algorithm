package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	private static int N, M,day=-1;
	private static int[][] map;
	private static Queue<int[]> RippenTomato = new LinkedList<>();;
	private static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // map 저장
				if(map[i][j]==1) RippenTomato.offer(new int[] {i,j}); // 익은 토마토 좌표를 queue에 저장
			}
		}
		BFS();
		bw.write(String.valueOf((check()?day-1:-1))); // 토마토가 다 익었으면 결과값 출력 아니면 -1 출력
		bw.close();
	}

	private static void BFS() { // 넓이 우선 탐색으로 해당 토마토마다 상하좌우 토마토를 익게함
		while(!RippenTomato.isEmpty()) {
		int[] curr = RippenTomato.poll();
		for(int i = 0; i<4;i++) {
			if(curr[0]+dy[i] < N && curr[0]+dy[i] >= 0 && curr[1]+dx[i] < M && curr[1]+dx[i] >= 0) {
				if(map[curr[0]+dy[i]][curr[1]+dx[i]] == 0) {// 익은 토마토 상하좌우에 안 익은 토마토가 존재한다면
					map[curr[0]+dy[i]][curr[1]+dx[i]] = map[curr[0]][curr[1]]+1; //새로 익은 토마토에 영향을 받은 토마토가 익은 일수 + 1을 저장
					RippenTomato.offer(new int[] {curr[0]+dy[i],curr[1]+dx[i]}); // queue에 넣어줌
				}
			}
		}
		}
	}
	private static boolean check() { // 익지 않은 토마토가 존재하는지  + 토마토가 익는데 걸린 최대 일수 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) return false;
				else day = Math.max(day, map[i][j]);
			}
			}
		return true;
	}
}
