package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * dfs? 빡코딩?
 * moving이란 함수를 이용해 재귀적으로 풂.
 * 인수로 방향을 가리키는 dir, 파이프의 "끝"점을 가리키는 r과 c를 넘겨줌.
 * dir: 0 = 가로로 이동 / dir: 1 = 대각선으로 이동 / dir: 2 = 세로로 이동
 * 각 방향에 맞게 이동할 수 있는 위치로 재귀적으로 함수를 넘겨줌.
 * dp로 개선하면 좋을 듯함.
 * 
 * */
public class parksr {
	static int cnt = 0;

	public static void moving(int dir, int r, int c, int[][] map) {
		// 범위 아웃이거나 장애물이 있는 경우 return.
		if (r > map.length - 1 || c > map.length - 1 || map[r][c] == 1) {
			return;
		}
		// 대각선은 조건이 까다롭길래 그냥 if문으로 하나 빼줬습니다.
		if (dir % 3 == 1 && (map[r - 1][c] == 1 || map[r][c - 1] == 1)) {
			return;
		}
		// 끝까지 도착했다면 정답 cnt 하나 증가.
		if (r == map.length - 1 && c == map.length - 1) {
			cnt++;
			return;
		}
		if (dir % 3 == 0) { // 가로
			moving(dir, r, c + 1, map);
			moving(dir + 1, r + 1, c + 1, map);
		}
		else if (dir % 3 == 1) { // 대각선
			moving(dir - 1, r, c + 1, map);
			moving(dir, r + 1, c + 1, map);
			moving(dir + 1, r + 1, c, map);
		}
		else { // 세로
			moving(dir, r + 1, c, map);
			moving(dir - 1, r + 1, c + 1, map);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		moving(0, 1, 2, map);
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
