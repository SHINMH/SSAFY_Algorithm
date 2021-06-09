package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class POS {
	int x, y;
	public POS(int y, int x) {
		super();
		this.x = x;
		this.y = y;
	}
	public POS() {
	}
}

public class BOJ_16197 {
	private static int ans = 11; // 버튼 클릭 횟수 10초과 불가
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		POS[] target = new POS[2];
		for (int row = 0,idx = 0; row < R; row++) {
			String str = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
				if (map[row][col] == 'o') { // 동전 2개의 위치 저장
					target[idx++] = new POS(row, col);
				}
			}
		}
		dfs(map, target, R, C, 0);
		bw.write(String.valueOf((ans < 11) ? ans : -1));
		bw.close();
	}

	private static void dfs(char[][] map, POS[] target, int R, int C, int cnt) {
		if (cnt == ans || cnt > 10) // 기저 조건 1
			return;
		int[] dy = { 0, 0, -1, 1 }, dx = { -1, 1, 0, 0 }; // 이동 값
		for (int i = 0; i < 4; i++) {
			POS[] nextTarget = new POS[2]; // 동전 2개의 다음 위치 값
			nextTarget[0] = new POS(dy[i] + target[0].y, dx[i] + target[0].x);
			nextTarget[1] = new POS(dy[i] + target[1].y, dx[i] + target[1].x);

			byte[] flag = new byte[2]; // 동전 2개가 밖에 나갔는지 확인
			flag[0] = check(nextTarget[0], R, C);
			flag[1] = check(nextTarget[1], R, C);
			if ((flag[0] & flag[1]) == 1) // 기저 조건2 둘 다 나갔을 때
				continue;
			else if ((flag[0] ^ flag[1]) == 1) { // 기저 조건3 하나만 나갔을 때
				ans = cnt + 1;
				return;
			} else {
				if (map[nextTarget[0].y][nextTarget[0].x] == '#')  // 벽 만났을 때 움직이지 않음
					nextTarget[0] = new POS(target[0].y,target[0].x);
				if (map[nextTarget[1].y][nextTarget[1].x] == '#') // 벽 만났을 때 움직이지 않음
					nextTarget[1] = new POS(target[1].y,target[1].x);
			
				if ((nextTarget[0].y == nextTarget[1].y) && (nextTarget[0].x == nextTarget[1].x)) // 기저 조건4 두 동전이 겹쳤을 때
					continue; 
				dfs(map, nextTarget, R, C, cnt + 1);
			}
		}
	}
	private static byte check(POS target, int R, int C) {
		if (target.y < 0 || target.x < 0 || target.y >= R || target.x >= C)
			return 1; // 동전 빠져나감
		else 
			return 0;
	}
}
