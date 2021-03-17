package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * DFS를 사용해 풀이.
 * 부분집합을 구해줌.
 * 대신 visit[cnt] = true 이렇게 대신 구역 번호인 1과 2를 넣어줌.
 * 부분집합이 구해지면 집합을 check 함수를 통해 몇 개 구역으로 나눠져있는지 count한 후
 * 그 count가 2라면 각 구역 합의 차이가 가장 작을 때를 구해줌.
 * 
 * */
public class parksr {
	static int total = 0;
	static int Min = Integer.MAX_VALUE;
	static int[] people;
	static int[] area;
	static boolean[][] connected;
	static boolean[] visited;
	static int N;

	// cnt : 부분집합 구할 때 현재 인덱스
	// areaNum : 1구역의 수
	// areaSum : 1구역의 합
	public static void dfs(int cnt, int areaNum, int areaSum) {
		if (cnt == N + 1) {
			// 1구역과 2구역의 수를 각각 센당.

			visited = new boolean[N + 1];

			int rs = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					// 이 check 함수를 거치고 나면 그랑 연결된 구역이 visit됨.
					// 즉, 한 번 돌고나면 한 구역을 전체 탐색한 셈이므로 구역수인 rs를 하나 증가시킨다.
					check(i, area[i]);
					rs++;
				}
			}
			// rs가 2가 아니라면 -> 구역이 제대로 나눠진게 아니란 뜻. 2여야 딱 2구역으로 나눠진 것이다.
			if (rs == 2) {
				Min = Math.min(Min, Math.abs((total - areaSum) - areaSum));
			}
			return;
		}

		area[cnt] = 1;
		dfs(cnt + 1, areaNum + 1, areaSum + people[cnt]);
		area[cnt] = 2;
		dfs(cnt + 1, areaNum, areaSum);
	}

	private static void check(int index, int belongArea) {
		// index : 현재 구역. 이 구역과 연결된 다른 구역을 찾을 것.
		// 2-1,2,5,6 인 상태에서, index = 2라고 해보자.
		visited[index] = true;

		for (int i = 1; i <= N; i++) {
			// ex) i=1일 때
			// 1과2가이어져있고 & 1을아직방문안했고 & 1의구역이 2의구역과같다면?!
			if (connected[index][i] && !visited[i] && area[i] == belongArea) {
				// 1이랑 이어져있는 애도 보자.
				check(i, belongArea);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/* 입력부 */
		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		area = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total += people[i];
		}

		connected = new boolean[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				connected[i][tmp] = true;
				connected[tmp][i] = true;
			}
		}
		/* 함수 실행부 */
		dfs(1, 0, 0);
		bw.write(String.valueOf(Min!=Integer.MAX_VALUE?Min:-1));

		bw.flush();
		bw.close();
		br.close();
	}
}
