package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int x; // 토마토가 있는 x 좌표
	int y; // 토마토가 있는 y 좌표
	int day; // 해당 토마토가 익기까지 걸린 날짜

	public Tomato(int x, int y, int day) {
		super();
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class BJ_7576 {
	static int M, N;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 }; // 방향 배열(상하좌우)
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Tomato> queue = new LinkedList<>(); // 탐색할 토마토를 저장하는 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 상자 세로
		N = Integer.parseInt(st.nextToken()); // 상자 가로

		arr = new int[N][M]; // 토마토 상자 상태를 나타내는 배열

		/* 토마토 정보 저장 */
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
	}

	// BFS는 시작 노드에서 출발해서 인접한 노드를 먼저 탐색하는 방법
	// BFS는 재귀적으로 동작  X. Queue 사용(방문한 노드들을 차례로 저장 후 순서대로 꺼내야 하므로)
	// 어떤 노드를 방문했는지 여부 검사 필수(여기서는 익은 토마토 표시(1)이 그 역할)
	public static void bfs() {
		int day = 0; // 토마토가 익기까지 걸리는 날짜
		
		/* 익은 토마토 찾기 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					queue.offer(new Tomato(i, j, 0)); // 익은 토마토 기준으로 탐색하기 위해 큐에 저장
				}
			}
		}

		/* 큐가 빌때까지 익은 토마토 주변 탐색하면서 날짜 기록 */
		while (!queue.isEmpty()) {
			Tomato toma = queue.poll(); // 익은 토마토 좌표 poll()
			day = toma.day; // 현재 시점으로 날짜 기록

			/* 4방 탐색 */
			for (int i = 0; i < 4; i++) {
				int nx = toma.x + dx[i];
				int ny = toma.y + dy[i];

				// index 범위 체크
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 토마토 익게 하기
					if (arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						queue.offer(new Tomato(nx, ny, day + 1)); // 익은 토마토 큐에 넣기(다음 탐색을 위해)
					}
				}
			}
		}
		
		/* 토마토 다 익었나 체크 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) { // 익지 않은 토마토가 있는 경우
					System.out.println(-1);
					return;
				}
			}
		}
		
		/* 다 익은 경우 익기까지 걸린 날짜 출력 */
		System.out.println(day);
		return;
	}
}
