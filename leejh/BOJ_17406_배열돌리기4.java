package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 각행에 있는 모든 수의 합 중 최솟값 
// 회전 연산 r,c,s 
// 가장 왼쪽 윗칸 r-s, c-s 
// 가장 오른쪽 아랫칸 r+s, c+s 
// 정사각현을 시계방향으로 한칸식 돌린다는 의미 
// 회전 연산은 모두 한번씩 사용해야 하며, 순서는 임의로 정해도 된다. 
public class BOJ_17406_배열돌리기4 {
	static int N, M, K, map[][], rotateInfo[][], origin[][], selected[], ans;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		origin = new int[N + 1][M + 1];
		// 배열 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				origin[i][j] = map[i][j];
			}
		}
		// 순열위한 배열들 ..
		rotateInfo = new int[K][3];
		isSelected = new boolean[K];
		selected = new int[K];
		ans = Integer.MAX_VALUE;
		// 회전 정보 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r, c, s;
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			rotateInfo[i][0] = r;
			rotateInfo[i][1] = c;
			rotateInfo[i][2] = s;
		}
		// 회전 순서 선택 메소드
		selectOrder(0);
		System.out.println(ans);
	}

	static void selectOrder(int cnt) {
		if (cnt == K) {
			for (int i = 0; i < K; i++) {
				rotateArr(rotateInfo[selected[i]][0], rotateInfo[selected[i]][1], rotateInfo[selected[i]][2]);
			}
			int min = minRow();
			if (ans > min)
				ans = min;
			// 배열 원래대로 되돌리기
			copy(map, origin);
			return;
		}

		for (int i = 0; i < K; i++) {
			if (isSelected[i])
				continue;
			selected[cnt] = i;
			isSelected[i] = true;
			selectOrder(cnt + 1);
			isSelected[i] = false;
		}

	}

	static void rotateArr(int r, int c, int s) {
		// 가장 왼쪽 윗칸 r-s, c-s
		// 가장 오른쪽 아랫칸 r+s, c+s
		// 3, 4, 2 (r,c,s)

		int a1 = r - s;
		int a2 = c - s;
		int b1 = r + s;
		int b2 = c + s;

		while (true) {
			// ->
			int tmpRight = map[a1][b2];
			for (int j = b2; j > a2; j--) {
				map[a1][j] = map[a1][j - 1];
			}

			// 아래
			int tmpBottom = map[b1][b2];
			for (int i = b1; i > a1 + 1; i--) {
				map[i][b2] = map[i - 1][b2];
			}

			map[a1 + 1][b2] = tmpRight;

			// <-
			int tmpLeft = map[b1][a2];
			for (int i = a2; i < b2 - 1; i++) {
				map[b1][i] = map[b1][i + 1];
			}

			map[b1][b2 - 1] = tmpBottom;

			// 위
			for (int i = a1; i < b1 - 1; i++) {
				map[i][a2] = map[i + 1][a2];
			}

			map[b1 - 1][a2] = tmpLeft;

			a1++;
			a2++;
			b1--;
			b2--;

			if (a1 == b1 && a2 == b2)
				break;
		}

	}

	static int minRow() {
		int min = 101;
		for (int i = 1; i <= N; i++) {
			int rowSum = 0;
			for (int j = 1; j <= M; j++) {
				rowSum += map[i][j];
			}
			if (min > rowSum)
				min = rowSum;
		}
		return min;
	}

	static void copy(int[][] map, int[][] origin) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}

	static void printArr() {
		System.out.println();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				System.out.print(map[i][j] + " ");System.out.println();}

		System.out.println();
	}

}