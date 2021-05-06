package leejh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16236 {
	private static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // 상, 좌, 하, 우
	
	private static class Shark {
		int x, y, size, eat, dist;
		Shark(int x, int y, int size, int eat, int dist) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N]; // 먹이 탐색 시 중복 제거를 위한 배열
		int SX = 0, SY = 0;
		String[] input;
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] == 9) { // 아기 상어 최초 위치
					SX = i;
					SY = j;
				}
			}
		}
		BFS(map, visited, N, SX, SY);
	}

	private static void BFS(int[][] map, boolean[][] visited, int N, int SX, int SY) {
		Queue<Shark> queue = new LinkedList<>();
		queue.add(new Shark(SX, SY, 2, 0, 0)); // 처음 아기 상어의 x좌표, y좌표, 크기, 먹은 횟수, 이동한 거리)
		visited[SX][SY] = true;
		// 걸린 시간
		int time = 0;

		while (!queue.isEmpty()) {
			int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
			int size = 0, eat = 0, dist = 0;

			int qSize = queue.size();
			for (int j = 0; j < qSize; j++) {
				Shark shark = queue.poll();

				for (int i = 0; i < 4; i++) { // 4방향 이동
					int nx = shark.x + dir[i][0];
					int ny = shark.y + dir[i][1];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] > shark.size)
						continue; 
					visited[nx][ny] = true;
					// 이동한 상어의 위치와 크기, 먹은 횟수 그리고 한 칸 이동했다는 의미로 dist+1 값을 큐에 넣음
					queue.add(new Shark(nx, ny, shark.size, shark.eat, shark.dist + 1));

					// 다음 위가 현재의 아기 상어보다 작은 물고기가 있는 곳이라면
					if (map[nx][ny] != 0 && map[nx][ny] != shark.size) {
						if (nx < minX) { // 가장 가까이, 가장 위에 있는 물고기라면
							// 그 때의 위치, 크기, 횟수, 거리+1 값을 변수에 저장
							minX = nx;
							minY = ny;
							size = shark.size;
							eat = shark.eat;
							dist = shark.dist + 1;
						} else if (nx == minX) { // 이미 가장 위에 있는 물고기라면
							if (ny < minY) { // 가장 왼쪽에 있는 물고기인지 확인 후, 그 때의 값 변수에 저장
								minX = nx;
								minY = ny;
								size = shark.size;
								eat = shark.eat;
								dist = shark.dist + 1;
							}
						}
					}
				}
			}

			// minX가 MAX값이 아니라 바뀌었다면 먹을 물고기가 있다는 것
			if (minX != Integer.MAX_VALUE) {
				eat++; // 물고기를 먹고, 먹은 횟수 추가
				// 아기 상어가 자신의 크기와 같은 수의 물고기를 먹었다면
				if (eat == size) {
					size++; // 크기 1 증가
					eat = 0;
				}
				// 아기 상어 위치 이동
				map[SX][SY] = 0; 
				map[minX][minY] = 9;
				SX = minX;
				SY = minY;

				time += dist; // 이동 거리 
				visited = new boolean[N][N]; // 재탐색을 위한 방문 초기화
				queue = new LinkedList<>(); // 이전에 탐색하던 것들은 필요 없으므로 제거

				// 이동된 위치에서 다시 아기 상어 탐색
				visited[minX][minY] = true;
				queue.add(new Shark(minX, minY, size, eat, 0));
			}
		}
		System.out.println(time); // 더이상 먹을 물고기가 없을 때, 지금까지 누적된 시간 출력 후 종료
	}
}