package DFS_BFS.BOJ_17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * [BOJ_17070] 파이프 옮기기 1
 * 1. 파이프의 끝부분 위치만 고려한다.
 * 2. 파이프는 (0,1)부터 시작하고 오른쪽(ㅡ),오른쪽 대각선(\),아래(ㅣ) 3가지 방향으로만 이동가능하다.
 * 2-1. 현재 파이프가 'ㅡ' 모양이면  ㅡ,\ 방향으로 밖에 못 움직인다.
 * 2-2. 현재 파이프가 '\' 모양이면 3가지 방향으로 모두 이동가능하지만 \로 이동 시 현재 파이프 끝부분의 오른쪽과 아래가 1이면 안된다.
 * 2-3. 현재 파이프가 'ㅣ' 모양이면 ㅣ,\ 방향으로 밖에 못 움직인다.
 * 3. 파이프 끝 부분이 (N-1,N-1)에 도달하면 count를 1 증가 시켜준다.
 */

public class leejh {
	private static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		String[] input;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = input[j].charAt(0);
		}

		dfs(map, 0, 1, N, 0); // (0,1) 지점부터 dfs 시작
		bw.write(String.valueOf(cnt));
		bw.close();
	}

	private static void dfs(char[][] map, int r, int c, int N, int dir) {
		if (r == N - 1 && c == N - 1) { // 목적지에 도착한 경우 cnt + 1
			cnt++;
			return;
		}
		int[] dy = { 0, 1, 1 }, dx = { 1, 1, 0 }; // ㅡ(d==0)  \(d==1) l(d==2) 순서로 이동
		for (int d = 0; d < 3; d++) {
			if ((dir == 0 && d == 2) || (dir == 2 && d == 0)) continue; //위 주석의 2-1과 2-3 예외처리
			int ny = r + dy[d], nx = c + dx[d]; // 다음 위치
			if (ny >= N || nx >= N) continue; // 다음 위치의 유효성 검사
			if (map[ny][nx] == '0') { 
				if (d == 1 && (map[ny - 1][nx] == '1' || map[ny][nx - 1] == '1')) // 위 주석의 2-2 예외처리
					continue;
				dfs(map, ny, nx, N, d);
			}
		}
	}
}
