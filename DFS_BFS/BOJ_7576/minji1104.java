package SSAFY_Algorithm.DFS_BFS.BOJ_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 토마토 

// 인접 토마토는 하루 뒤 익음 ( 사방 )
// 며칠 지나면 다 익는지 최수 일수 

// 1.익은 토 / 2.안익은 토 / -1. 없는 토 


// 0212 - cnt 현재 각각 세어져서 고쳐야함 - 어떻게 ?
public class minji1104 {

	static int m, n;
	static int cnt, zeroCnt, minusCnt;
	static int[][] arr;
	static boolean[][] isTomato;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		isTomato = new boolean[n][m];
		zeroCnt = 0;
		cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				// 원래 익은 토마토 미리 표시
				if (arr[i][j] == 1) {
					isTomato[i][j] = true;
				}

				else if (zeroCnt == 0) { // 저장 시 모든 토마토 익었으면 0
					cnt = 0;
				}

			}
		}

		check(0);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					zeroCnt++;
				}
				if (zeroCnt > 0) {
					cnt = -1; // 토마토 익지 못하는 상황이면 -1 : 0이 하나라도 있으면
				}
			}
		}

		System.out.println("======토마토 상황 ====");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// 토마토 모두 익을 때 최소 날짜 출력
		System.out.println("최소 날짜 : "+cnt);

	}

	static void check(int num) {
		
		// 이거 종료조건 어떻게 설정해줘야 할까 .. 
		if (num >= 5) {
//			System.out.println(num);
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != -1 && isTomato[nx][ny] == false) {
							isTomato[nx][ny] = true;
							arr[nx][ny] = 1;
							cnt++;
						}

					}

				}
		
			}
		}

		check(num + 1);
	}

}
