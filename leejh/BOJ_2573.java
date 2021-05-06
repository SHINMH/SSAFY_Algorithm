package leejh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2573 {
	static int N, M;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 }; // 해당 좌표 기준 상하좌우 이동 값
	static int[][] map;
	static boolean[][] visited;
	static int years = 0; // 소요 일 수 저장
	static ArrayList<int[]> removeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // row 값
		M = Integer.parseInt(st.nextToken()); // col 값
		map = new int[N][M];
		for (int row = 0; row < N; row++) { // map input
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++)
				map[row][col] = Integer.parseInt(st.nextToken());
		}
		while (true) { // 1년이 지났습니다.
			removeList = new ArrayList<>();
			int AreaNum = 0; // 빙하의 개수
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						AreaNum++;
						if (AreaNum > 1) break; // 빙하가 2이상 나눠지면 for문 탈출
						visited[i][j] = true;
						removeList.add(new int[] { i, j, check(i, j) });// 빙하를 제거 list에 추가
						DFS(i, j); // 빙하 발견 지점부터 이어진 빙하 깊이 우선 탐색 실행
					}
				}
				if (AreaNum > 1) break; // 빙하가 2이상 나눠지면 for문 탈출
			}
			if (AreaNum > 1) break; // 빙하가 2이상 일경우 while문 탈출
			if (AreaNum == 0) { // 빙하가 나누어지지 않고 다 녹았을 때 while문 탈출 후 0 출력
				years = 0;
				break;
			}
			for (int[] arr : removeList) map[arr[0]][arr[1]] -= arr[2]; // while문 마지막에서 녹아야하는 빙하들을 한 번에 녹임
			years++; // 1년이 지남
		}
		bw.write(String.valueOf(years));
		bw.close();
	}

	private static void DFS(int row, int col) {
		for (int i = 0; i < 4; i++) {
			int nextR = row + dy[i];
			int nextC = col + dx[i];

			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
				continue;

			if (map[nextR][nextC] > 0 && !visited[nextR][nextC]) {
				int cnt = check(nextR, nextC); // 바다와 접해있는 면의 개수
				if (cnt > 0) removeList.add(new int[] { nextR, nextC, cnt }); // 바다와 접해있는 빙하를 제거 리스트에 추가
				visited[nextR][nextC] = true;
				DFS(nextR, nextC);
			}
		}
	}

	private static int check(int row, int col) {// 바다와 접해있는 면의 개수 계산
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nextR = row + dy[i];
			int nextC = col + dx[i];
			if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M)
				continue;
			if (map[nextR][nextC] <= 0)
				cnt++;
		}
		return cnt;
	}
}